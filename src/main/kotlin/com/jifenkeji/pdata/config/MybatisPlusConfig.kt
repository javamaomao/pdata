package com.jifenkeji.pdata.config

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor
import org.mybatis.spring.annotation.MapperScan
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.transaction.annotation.EnableTransactionManagement

//Spring boot方式
@EnableTransactionManagement
@Configuration
@MapperScan("com.jifenkeji.pdata.mapper*")
class MybatisPlusConfig {

    /**
     * 分页插件
     */
    @Bean
    fun paginationInterceptor(): PaginationInterceptor {
        return PaginationInterceptor()
    }
}