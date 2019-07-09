package com.jifenkeji.pdata.tools

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.node.JsonNodeType
import java.io.File
import java.net.URL
import java.net.URLEncoder
import java.sql.DriverManager
import java.util.*
import kotlin.math.absoluteValue

fun main() {
    val database = "pdata"
    val tableNameMap = mutableListOf<Map<String,String>>()
    //
    ObjectMapper().readTree(File("database.json")).fields().forEach {item->
        val tableName = item.key
        val timeInfo = listOf("时间", "日期")
        val textNameList = listOf("备注", "内容", "正文", "新闻", "介绍")
        val fieldList = mutableListOf("`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键'")
        val fieldMapList = mutableListOf<Map<String, Any?>>()
        item.value.fields().asSequence().fold(fieldList) {acc, it->
            acc.apply {
                var defaultValue = "DEFAULT ${it.value}"
                val type = when(it.value.nodeType) {
                    JsonNodeType.BOOLEAN->"Bit"
                    JsonNodeType.NUMBER->"Int(10)"
                    JsonNodeType.STRING-> {
                        if (it.key.contains(timeInfo.joinToString("|").toRegex())) {
                            defaultValue = "DEFAULT CURRENT_TIMESTAMP"
                            "Timestamp"
                        }
                        else if (it.key.contains(textNameList.joinToString("|").toRegex())) {
                            defaultValue = ""
                            "Text"
                        } else {
                            "VarChar(255)"
                        }
                    }
                    else->"VarChar(255)"
                }
                //
                val keyId = transKey(it.key)
                //
                fieldMapList.add(mapOf("keyId" to keyId, "default" to it.value, "keyName" to  it.key))
                //
                this.add("`$keyId` $type ${defaultValue} COMMENT '${it.key}'")
            }
        }

        //
        val tableId = transKey(tableName)
        tableNameMap.add(mapOf("id" to tableId, "name" to tableName))
        //
        val sql = """
            |CREATE TABLE `tb_$tableId`(${fieldList.joinToString(",")} ,
            |PRIMARY KEY (`id`) USING BTREE)
            |ENGINE = MyISAM AUTO_INCREMENT = 26 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic COMMENT='${item.key}'
            |""".trimMargin()

        executeSql(database, sql)
        //
        CodeGenerator.makeFiles(database)
        //
        HtmlTemplateMaker.make(tableId, tableName, fieldMapList)
    }
    //
    HtmlTemplateMaker.makeMenu(mapOf("tables" to tableNameMap))
}

//
fun executeSql(database:String, sql: String) {
    //
    // MySQL 8.0 以下版本 - JDBC 驱动名及数据库 URL
    val JDBC_DRIVER = "com.mysql.cj.jdbc.Driver"
    val DB_URL = "jdbc:mysql://192.168.0.81:3306/?allowMultiQueries=true&useUnicode=true&characterEncoding=UTF-8"
    // 数据库的用户名与密码，需要根据自己的设置
    val USER = "root"
    val PASS = "yangguo999"

    runCatching {
        // 注册 JDBC 驱动
        Class.forName(JDBC_DRIVER);
        //val cls = Class.forName("com.mysql.cj.jdbc.Driver");
        val conn = DriverManager.getConnection(DB_URL,
                                               USER,
                                               PASS);
        conn.use {

            // 执行查询
            println(" 实例化Statement对象...")
            conn.createStatement().use { stmt ->
                stmt.use {
                    runCatching {
                        it.execute("create database $database")
                    }
                    runCatching {
                        it.execute("use $database")
                    }
                    it.execute(sql)
                }
            }
        }
    }.onFailure {
        println(it)
        println(sql)
    }
}
fun transKey(key: String): String {
    val map = mapOf("序号" to "id",
          "简介" to "intro",
          "大小" to "size",
          "等级" to "level")
    var keyName =  map[key] ?: youdaoTrans(key) ?: key

    keyName = keyName.toLowerCase()
    keyName = keyName.replace(" the", "")
    keyName = keyName.replace("the ", "")
    keyName = keyName.replace(" ", "_")

    return keyName
}

//
fun youdaoTrans(q : String): String? {
    val uq = URLEncoder.encode(q, "utf-8")
    val from = "auto"
    val to = "auto"
    val salt = Random().nextLong().absoluteValue.toString()
    val appKey = "64a446343b876c80"
    val key = "heUz598Ejon52JKqKNHxYiiO0avS0u0G"
    val s = appKey+q+salt+key
    val sign = s.md5.toUpperCase()
    val param = "?q=$uq&from=$from&to=$to&appKey=$appKey&salt=$salt&sign=$sign"
    val url = URL("http://openapi.youdao.com/api${param}")
    val ret = url.readText()
    //println(ret)
    val info = ObjectMapper().readValue(ret, YoudaoResult::class.java)
    info.translation?.forEach {
        println(it)
    }
    if (info.errorCode?.toInt() != 0){
        println(param)
        println(s)
    }
    return info.translation?.firstOrNull()
}