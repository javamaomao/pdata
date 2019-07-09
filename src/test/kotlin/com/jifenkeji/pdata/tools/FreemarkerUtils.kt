package com.jifenkeji.pdata.tools

import freemarker.cache.ClassTemplateLoader
import freemarker.cache.NullCacheStorage
import freemarker.template.Configuration
import freemarker.template.Template
import freemarker.template.TemplateExceptionHandler

import java.io.IOException

object FreemarkerUtils {

    private val cfg = Configuration(Configuration.VERSION_2_3_22)


    init {
        //这里用来指定模板所在的路径，本项目配置在resources/templates目录下，springBoot项目会默认到resources下读文件
        cfg.templateLoader =
                ClassTemplateLoader(FreemarkerUtils::class.java,
                                    "/tools/templates")
        cfg.defaultEncoding = "UTF-8"
        cfg.templateExceptionHandler = TemplateExceptionHandler.RETHROW_HANDLER
        cfg.cacheStorage = NullCacheStorage.INSTANCE
    }


    @Throws(IOException::class)
    fun getTemplate(templateName: String): Template {
        try {
            return cfg.getTemplate(templateName)
        } catch (e: IOException) {
            throw e
        }

    }
}