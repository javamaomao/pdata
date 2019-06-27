package com.jifenkeji.pdata.controller

import com.jifenkeji.pdata.entity.Admin
import com.jifenkeji.pdata.service.AdminService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

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

    @GetMapping("add")
    fun add(model: Model): Any? {
        model.set("admin", Admin())
        return "admin/add"
    }

    @PostMapping("add_save")
    @ResponseBody
    fun addSave(model: Model, admin: Admin?): Any? {
        //
        admin ?: return mapOf("result" to "error")

        adminService.add(admin)

        return mapOf("result" to "ok")
    }
    @GetMapping("del")
    fun del(id: Int?): Any? {
        id ?: return "redirect:/admin/list"

        adminService.removeByPrimaryKey(id)

        return "redirect:/admin/list"
    }
}