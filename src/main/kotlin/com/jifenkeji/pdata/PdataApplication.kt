package com.jifenkeji.pdata

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PdataApplication

fun main(args: Array<String>) {
    println("helloworld")
    runApplication<PdataApplication>(*args)

}
