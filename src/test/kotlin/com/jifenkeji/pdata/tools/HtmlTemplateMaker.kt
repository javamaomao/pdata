package com.jifenkeji.pdata.tools

import java.io.File

object HtmlTemplateMaker {
    //
    fun make(tableEnName: String,
             tableName: String,
             fieldMapList: List<Map<String, Any?>>) {
        val projectPath = System.getProperty("user.dir")
        val rootDir = File("$projectPath/src/main/resources/temp/$tableEnName")
        rootDir.mkdirs()

        val dataModel = mapOf("tableId" to tableEnName,
                              "tableName" to tableName,
                              "fieldMapList" to fieldMapList)
        // 生成显示记录的模板文件
        FreemarkerUtils.getTemplate("list.html.ftl")
                .process(dataModel, File(rootDir, "list.html").writer())
        // 生成新增记录的模板文件
        FreemarkerUtils.getTemplate("add.html.ftl")
                .process(dataModel, File(rootDir, "add.html").writer())
        // 生成修改记录的模板文件
        FreemarkerUtils.getTemplate("modify.html.ftl")
                .process(dataModel, File(rootDir, "modify.html").writer())
    }
    //
    fun makeMenu(datas: Map<String, Any?>) {
        val projectPath = System.getProperty("user.dir")
        val rootDir = File("$projectPath/src/main/resources/temp")
        rootDir.mkdirs()

        // 生成显示记录的模板文件
        FreemarkerUtils.getTemplate("common.html.ftl")
                .process(datas, File(rootDir, "common.html").writer())

    }
}

fun main() {
    val tableEnName = "guestBook"
    val tableName = "留言本"
    val fieldMapList = listOf(mapOf("姓名" to ""))
    HtmlTemplateMaker.make(tableEnName,
                           tableName,
                           fieldMapList)
}