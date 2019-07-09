package com.jifenkeji.pdata.controller

import com.jifenkeji.pdata.entity.Admin
import com.jifenkeji.pdata.service.IAdminGroupService
import com.jifenkeji.pdata.service.IAdminService
import com.jifenkeji.pdata.utils.MyPasswordEncoder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.DuplicateKeyException
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import com.baomidou.mybatisplus.core.metadata.IPage
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import com.baomidou.mybatisplus.extension.plugins.pagination.Page


@Controller
@RequestMapping("/admin")
class AdminController {

    @Autowired
    lateinit var adminService: IAdminService
    @Autowired
    lateinit var adminGroupService: IAdminGroupService

    @GetMapping("",
                "/",
                "list")
    fun list(model: Model, page: Long?, size: Long?): Any? {

        val admins = adminService.selectPageVo(page, size, 0)
        model.set("admins",
                  admins)

        //
        model.set("groups",
                  adminGroupService.listByMap(null))
        return "admin/list"
    }

    @GetMapping("role_mgr")
    fun ruleMgr(model: Model, page: Long?, size: Long?): Any? {
        val adminGroups = adminGroupService.selectPage(page, size)
        model.set("datas", adminGroups)
        return "admin/role_mgr"
    }

    @GetMapping("add")
    fun add(model: Model): Any? {
        model.set("admin",
                  Admin())
        return "admin/add"
    }

    @GetMapping("get_info")
    @ResponseBody
    fun getInfo(id: Int?): Any? {
        id ?: return null
        return adminService.getById(id)
    }

    @PostMapping("add_save")
    @ResponseBody
    fun addSave(model: Model, admin: Admin?): Any? {
        //
        admin ?: return mapOf("result" to "error", "msg" to "参数为空")
        //
        admin.userPassword?.let {
            admin.userPassword = MyPasswordEncoder().encode(it)
        }
        //
        adminService.runCatching {
            save(admin)
        }.onFailure {
            val errMsg = when (it) {
                is DuplicateKeyException-> "用户ID已经存在"
                else-> it.message
            }
            return mapOf("result" to "error",
                         "msg" to errMsg)
        }

        return mapOf("result" to "ok")
    }

    @PostMapping("edit_save")
    @ResponseBody
    fun editSave(model: Model, admin: Admin?): Any? {
        //
        admin ?: return mapOf("result" to "error",
                              "msg" to "参数错误")
        // 转换密码格式
        if (!admin.userPassword.isNullOrEmpty()) {
            admin.userPassword = MyPasswordEncoder().encode(admin.userPassword!!)
        }
        // 执行保存
        adminService.runCatching {
            updateById(admin)
        }.onFailure {
            return mapOf("result" to "error",
                         "msg" to "发生错误")
        }

        return mapOf("result" to "ok")
    }

    @GetMapping("del")
    fun del(id: Int?): Any? {
        id ?: return "redirect:/admin/list"

        adminService.removeById(id)

        return "redirect:/admin/list"
    }
}