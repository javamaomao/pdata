package com.jifenkeji.pdata.config

import com.jifenkeji.pdata.service.LoginInterceptor
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter

@Configuration
class WebAppConfig : WebMvcConfigurerAdapter() {
    override fun addInterceptors(registry: InterceptorRegistry) {
        registry!!.addInterceptor(LoginInterceptor()).addPathPatterns("/**")
    }
}