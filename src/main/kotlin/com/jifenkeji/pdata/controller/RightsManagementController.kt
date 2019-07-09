package com.jifenkeji.pdata.controller;

import com.jifenkeji.pdata.entity.RightsManagement
import com.jifenkeji.pdata.service.IRightsManagementService
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.ui.set
import org.springframework.web.bind.annotation.PostMapping
import javax.annotation.Resource

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 权限管理 前端控制器
 * </p>
 *
 * @author yangguo
 * @since 2019-07-08
 */
@Controller
@RequestMapping("/rightsManagement")
class RightsManagementController {
    val BasePath = "rightsManagement"

    @Resource
    lateinit var rightsManagementService: IRightsManagementService

    /**
    * <p>
    * 显示 权限管理 中所有项目
    * </p>
    *
    * @author yangguo
    * @since 2019-07-08
    */
    @GetMapping("/")
    fun list(m: Model): Any {

        val datas = rightsManagementService.list()

        m.set("datas", datas)
        return "$BasePath/list"
    }

    /**
    * <p>
    * 增加 权限管理 数据的表单
    * </p>
    *
    * @author yangguo
    * @since 2019-07-08
    */
    @GetMapping("/add")
    fun add(m: Model): Any {
        //
        val data = RightsManagement()
        m.set("data", data)

        return "$BasePath/add"
    }

    /**
    * <p>
    * 增加记录到 权限管理 表中
    * </p>
    *
    * @author yangguo
    * @since 2019-07-08
    */
    @PostMapping("/add_save")
    fun add_save(m: Model, rightsManagement: RightsManagement): Any {

        rightsManagementService.save(rightsManagement)

        return "redirect:/$BasePath/list"
    }

    /**
    * <p>
    * 编辑 权限管理 的表单
    * </p>
    *
    * @author yangguo
    * @since 2019-07-08
    */
    @GetMapping("/edit")
    fun edit(m: Model, id: Int?): Any {

        //
        val data = rightsManagementService.getById(id ?: 1)
        m.set("data", data)

        return "$BasePath/edit"
    }

    /**
    * <p>
    * 保存记录到 权限管理
    * </p>
    *
    * @author yangguo
    * @since 2019-07-08
    */
    @PostMapping("/edit_save")
    fun edit_save(m: Model, rightsManagement: RightsManagement): Any {

        rightsManagementService.updateById(rightsManagement)

        return "redirect:/$BasePath/list"
    }

    /**
    * <p>
    * 删除 权限管理表中的记录
    * </p>
    *
    * @author yangguo
    * @since 2019-07-08
    */
    @GetMapping("/del")
    fun del(m: Model, id: Int?): Any {
        id ?: return "redirect:/$BasePath/list"

        val datas = rightsManagementService.removeById(id)
        m.set("datas", datas)

        return "redirect:/$BasePath/list"
    }
}
