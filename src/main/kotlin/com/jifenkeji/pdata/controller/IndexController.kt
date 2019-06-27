package com.jifenkeji.pdata.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller

class IndexController {
    @GetMapping("/", "/index")
    fun index(): Any {
        return "/index"
    }
}