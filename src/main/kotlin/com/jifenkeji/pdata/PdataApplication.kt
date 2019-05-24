package com.jifenkeji.pdata

import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@MapperScan(basePackages = ["com.jifenkeji.pdata.mapper"])
class PdataApplication

fun main(args: Array<String>) {
    println("helloworld")
    println("xxxx")
    runApplication<PdataApplication>(*args)

}
