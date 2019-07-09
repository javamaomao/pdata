package com.jifenkeji.pdata.controller;

import com.jifenkeji.pdata.entity.AdminGroup
import com.jifenkeji.pdata.service.IAdminGroupService
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.ui.set
import org.springframework.web.bind.annotation.PostMapping
import javax.annotation.Resource

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yangguo
 * @since 2019-07-08
 */
@Controller
@RequestMapping("/adminGroup")
class AdminGroupController {
    val BasePath = "adminGroup"

    @Resource
    lateinit var adminGroupService: IAdminGroupService

    /**
    * <p>
    * 显示  中所有项目
    * </p>
    *
    * @author yangguo
    * @since 2019-07-08
    */
    @GetMapping("/")
    fun list(m: Model): Any {

        val datas = adminGroupService.list()

        m.set("datas", datas)
        return "$BasePath/list"
    }

    /**
    * <p>
    * 增加  数据的表单
    * </p>
    *
    * @author yangguo
    * @since 2019-07-08
    */
    @GetMapping("/add")
    fun add(m: Model): Any {
        //
        val data = AdminGroup()
        m.set("data", data)

        return "$BasePath/add"
    }

    /**
    * <p>
    * 增加记录到  表中
    * </p>
    *
    * @author yangguo
    * @since 2019-07-08
    */
    @PostMapping("/add_save")
    fun add_save(m: Model, adminGroup: AdminGroup): Any {

        adminGroupService.save(adminGroup)

        return "redirect:/$BasePath/list"
    }

    /**
    * <p>
    * 编辑  的表单
    * </p>
    *
    * @author yangguo
    * @since 2019-07-08
    */
    @GetMapping("/edit")
    fun edit(m: Model, id: Int?): Any {

        //
        val data = adminGroupService.getById(id ?: 1)
        m.set("data", data)

        return "$BasePath/edit"
    }

    /**
    * <p>
    * 保存记录到 
    * </p>
    *
    * @author yangguo
    * @since 2019-07-08
    */
    @PostMapping("/edit_save")
    fun edit_save(m: Model, adminGroup: AdminGroup): Any {

        adminGroupService.updateById(adminGroup)

        return "redirect:/$BasePath/list"
    }

    /**
    * <p>
    * 删除 表中的记录
    * </p>
    *
    * @author yangguo
    * @since 2019-07-08
    */
    @GetMapping("/del")
    fun del(m: Model, id: Int?): Any {
        id ?: return "redirect:/$BasePath/list"

        val datas = adminGroupService.removeById(id)
        m.set("datas", datas)

        return "redirect:/$BasePath/list"
    }
}
