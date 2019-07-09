package com.jifenkeji.pdata.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("activity")
class ActivityController {
    @GetMapping("/", "/product_code_list")
    fun index(): Any {
        return "activity/product_code_list"
    }
    @GetMapping("add")
    fun add(): Any {
        return "activity/add"
    }
}