package com.jifenkeji.pdata.controller

import com.jifenkeji.pdata.service.AdminService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/admin")
class AdminController {

    @Autowired
    lateinit var adminService: AdminService

    @GetMapping("", "/", "list")
    fun list(model: Model): Any? {
        val admins = adminService.findAll()
        model.set("admins", admins)
        return "admin/list"
    }
}