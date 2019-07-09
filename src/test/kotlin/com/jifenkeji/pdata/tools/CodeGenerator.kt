package com.jifenkeji.pdata.tools

import com.baomidou.mybatisplus.core.toolkit.StringPool
import com.baomidou.mybatisplus.generator.AutoGenerator
import com.baomidou.mybatisplus.generator.InjectionConfig
import com.baomidou.mybatisplus.generator.config.*
import com.baomidou.mybatisplus.generator.config.po.TableInfo
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine
import java.io.File

fun main() {
    CodeGenerator.makeFiles("test_demo")
}

// 演示例子，执行 main 方法控制台输入模块表名回车自动生成对应项目目录中
object CodeGenerator {
    fun makeFiles(database: String) {
        // 代码生成器
        val mpg = AutoGenerator()
        // 全局配置
        val gc = GlobalConfig()
        val projectPath = System.getProperty("user.dir")
        gc.outputDir = "$projectPath/src/main/kotlin"
        gc.author = "yangguo"
        gc.isOpen = false
        gc.isKotlin = true
        // gc.setSwagger2(true); 实体属性 Swagger2 注解
        mpg.globalConfig = gc

        // 数据源配置
        val dsc = DataSourceConfig()
        dsc.url = "jdbc:mysql://192.168.0.81:3306/$database?allowMultiQueries=true&useUnicode=true&characterEncoding=UTF-8"
        // dsc.setSchemaName("public");
        //dsc.setDriverName("com.mysql.jdbc.Driver")
        dsc.driverName = "com.mysql.cj.jdbc.Driver"
        dsc.username = "root"
        dsc.password = "yangguo999"
        mpg.dataSource = dsc

        // 包配置
        val pc = PackageConfig()
        //pc.setModuleName(scanner("模块名"))
        //pc.moduleName = ""
        pc.parent = "com.jifenkeji.pdata"
        pc.xml = "mapper/xml"
        pc.mapper = "mapper"
        mpg.packageInfo = pc

        // 自定义配置
        val cfg = object : InjectionConfig() {
            override fun initMap() {
                // to do nothing
            }
        }

        // 如果模板引擎是 freemarker
//        val templatePath = "/templates/mapper.xml.ftl"
        // 如果模板引擎是 velocity
        // String templatePath = "/templates/mapper.xml.vm";

//        // 自定义输出配置
//        val focList = ArrayList<FileOutConfig>()
//        // 自定义配置会被优先输出
//        focList.add(object : FileOutConfig(templatePath) {
//            override fun outputFile(tableInfo: TableInfo): String {
//
//                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
//                val dirName = projectPath + "/src/main/resources/mapper/xml/"
//                val fileName = tableInfo.entityName
//                return "$dirName${File.separator}$fileName"
//
////                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
////                return (projectPath + "/src/main/resources/mapper/" + pc.moduleName
////                        + "/" + tableInfo.entityName + "Mapper" + StringPool.DOT_XML)
//            }
//        })

        /*
        cfg.fileCreate = object : IFileCreate {
            override fun isCreate(configBuilder: ConfigBuilder, fileType: FileType, filePath: String): Boolean {
                // 判断自定义文件夹是否需要创建
                checkDir("调用默认方法创建的目录")
                return false
            }
        }
        */
     //   cfg.fileOutConfigList = focList
        mpg.cfg = cfg

        // 配置模板
        val templateConfig = TemplateConfig()

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        // templateConfig.setEntity("templates/entity2.java");
        // templateConfig.setService();
        templateConfig.setController("tools/controller.kt");

        //templateConfig.xml = null

        mpg.template = templateConfig

        // 策略配置
        val strategy = StrategyConfig()
        strategy.naming = NamingStrategy.underline_to_camel
        strategy.columnNaming = NamingStrategy.underline_to_camel
        //strategy.setSuperEntityClass("com.baomidou.ant.common.BaseEntity")
        strategy.isEntityLombokModel = false
        strategy.isRestControllerStyle = false
        // 公共父类
        //strategy.setSuperControllerClass("com.baomidou.ant.common.BaseController")
        // 写于父类中的公共字段
        strategy.setSuperEntityColumns("id")
        //
        //val tableName = scanner("表名，多个英文逗号分割").split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        //strategy.setInclude(*tableName)
        strategy.setExclude("")
        strategy.isControllerMappingHyphenStyle = false
        //strategy.setTablePrefix(pc.moduleName + "_")
        strategy.setTablePrefix("tb_")
        mpg.strategy = strategy
        mpg.templateEngine = FreemarkerTemplateEngine()
        mpg.execute()
    }

}