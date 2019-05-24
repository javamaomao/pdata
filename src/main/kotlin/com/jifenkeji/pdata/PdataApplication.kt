package com.jifenkeji.pdata

import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession

@SpringBootApplication
@EnableRedisHttpSession
@MapperScan(basePackages = ["com.jifenkeji.pdata.mapper"])
class PdataApplication

fun main(args: Array<String>) {
    runApplication<PdataApplication>(*args)
}
