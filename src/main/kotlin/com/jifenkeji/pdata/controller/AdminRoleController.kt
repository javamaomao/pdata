package com.jifenkeji.pdata.controller


import com.jifenkeji.pdata.entity.AdminRole
import com.jifenkeji.pdata.service.IAdminAuthorityService
import com.jifenkeji.pdata.service.IAdminRoleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.DuplicateKeyException
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@RequestMapping("/adminRole")
class AdminRoleController {


    @Autowired
    lateinit var adminroleService : IAdminRoleService

    @Autowired
    lateinit var  adminauthorityService :IAdminAuthorityService


    //分页查询
    @GetMapping("" ,"/","role_mgr")
    //@ResponseBody
    fun ruleMgr(model: Model, page: Long?, size: Long?): Any? {
        val adminroles = adminroleService.selectPage(page, size)
        model.set("datas",adminroles)
        model.set("auth",adminauthorityService.listByMap(null))
        return "admin/role_mgr"
    }

    //分页搜索
    @GetMapping("search")
    fun search(model: Model,page: Long?,size: Long?,words:String?):Any?{
        val admins=adminroleService.search(page,size,words ?:"")
        model.set("datas", admins)
        model.set("words", words ?: "")
        model.set("auth",adminauthorityService.listByMap(null))
        return "admin/role_mgr"
    }

    //添加角色
    @PostMapping("add_save")
    @ResponseBody
    fun addSave(model: Model, adminrole: AdminRole?): Any? {

        adminrole ?: return mapOf("result" to "error", "msg" to "参数为空")
        adminroleService.runCatching {
            save(adminrole)
        }.onFailure {
            val errMsg = when (it) {
                is DuplicateKeyException -> "该角色已经存在"
                else-> it.message
            }
            return mapOf("result" to "error",
                    "msg" to errMsg)
        }
        return mapOf("result" to "ok")
    }

    //获取单体
    @GetMapping("get_info")
    @ResponseBody
    fun getInfo(model :Model,id: Int?): Any? {
        id ?: return null
        return adminroleService.getById(id)
    }

    //修改角色
    @PostMapping("edit_save")
    @ResponseBody
    fun editSave(model: Model, adminrole: AdminRole?): Any? {
        adminrole ?: return mapOf("result" to "error", "msg" to "参数错误")
        // 执行保存
        adminroleService.runCatching {
            updateById(adminrole)
        }.onFailure {
            return mapOf("result" to "error",
                    "msg" to "发生错误")
        }
        return mapOf("result" to "ok")
    }

    //删除角色
    @GetMapping("del")
    fun del(id: Int?): Any? {
        id ?: return "redirect:/admin/list"
        adminroleService.removeById(id)
        return "redirect:/adminRole/role_mgr"
    }

}


