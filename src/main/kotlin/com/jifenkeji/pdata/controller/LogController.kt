package com.jifenkeji.pdata.controller;

import com.jifenkeji.pdata.entity.Log
import com.jifenkeji.pdata.service.ILogService
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.ui.set
import org.springframework.web.bind.annotation.PostMapping
import javax.annotation.Resource
import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import org.springframework.web.bind.annotation.ResponseBody

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 日志 前端控制器
 * </p>
 *
 * @author yangguo
 * @since 2019-07-22
 */
@Controller
@RequestMapping("/log")
class LogController {
    val BasePath = "log"

    @Resource
    lateinit var logService: ILogService

    /**
    * <p>
    * 显示 日志 中所有项目
    * </p>
    *
    * @author yangguo
    * @since 2019-07-22
    */
    @GetMapping("/", "", "list")
    fun list(m: Model, page: Long?, size: Long?): Any {

        val datas = logService.page(Page<Log>(page ?: 1, size ?: 10), null)

        m.set("datas", datas)
        return "$BasePath/list"
    }

    /**
    * <p>
    * 增加 日志 数据的表单
    * </p>
    *
    * @author yangguo
    * @since 2019-07-22
    */
    @GetMapping("/add")
    fun add(m: Model): Any {
        //
        val data = Log()
        m.set("data", data)

        return "$BasePath/add"
    }

    /**
    * <p>
    * 获取 日志 的数据
    * </p>
    *
    * @author yangguo
    * @since 2019-07-22
    */
    @GetMapping("/get")
    @ResponseBody
    fun get(m: Model, id: Int): Any {
        //
        return logService.getById(id)
    }
    /**
    * <p>
    * 增加记录到 日志 表中
    * </p>
    *
    * @author yangguo
    * @since 2019-07-22
    */
    @PostMapping("/add-save")
    fun addSave(m: Model, log: Log): Any {

        logService.save(log)

        return "redirect:/$BasePath/list"
    }

    /**
    * <p>
    * 编辑 日志 的表单
    * </p>
    *
    * @author yangguo
    * @since 2019-07-22
    */
    @GetMapping("/edit")
    fun edit(m: Model, id: Int?): Any {

        //
        val data = logService.getById(id ?: 1)
        m.set("data", data)

        return "$BasePath/edit"
    }

    /**
    * <p>
    * 保存记录到 日志
    * </p>
    *
    * @author yangguo
    * @since 2019-07-22
    */
    @PostMapping("/edit-save")
    fun editSave(m: Model, log: Log): Any {

        logService.updateById(log)

        return "redirect:/$BasePath/list"
    }

    /**
    * <p>
    * 删除 日志表中的记录
    * </p>
    *
    * @author yangguo
    * @since 2019-07-22
    */
    @GetMapping("/del")
    fun del(m: Model, id: Int?): Any {
        id ?: return "redirect:/$BasePath/list"

        val datas = logService.removeById(id)
        m.set("datas", datas)

        return "redirect:/$BasePath/list"
    }
}
