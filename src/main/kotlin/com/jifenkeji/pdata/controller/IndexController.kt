package com.jifenkeji.pdata.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller

class IndexController {
    @GetMapping("/", "/index")
    fun index(): Any {
        return "/index"
    }

    @GetMapping("/test1")
    @ResponseBody
    fun test1(): Any? {
        return ""
    }
}