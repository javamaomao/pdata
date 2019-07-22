package com.jifenkeji.pdata.controller;

import com.jifenkeji.pdata.entity.Test
import com.jifenkeji.pdata.service.ITestService
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
 * 测试 前端控制器
 * </p>
 *
 * @author yangguo
 * @since 2019-07-22
 */
@Controller
@RequestMapping("/test")
class TestController {
    val BasePath = "test"

    @Resource
    lateinit var testService: ITestService

    /**
    * <p>
    * 显示 测试 中所有项目
    * </p>
    *
    * @author yangguo
    * @since 2019-07-22
    */
    @GetMapping("/", "", "list")
    fun list(m: Model, page: Long?, size: Long?): Any {

        val datas = testService.page(Page<Test>(page ?: 1, size ?: 10), null)

        m.set("datas", datas)
        return "$BasePath/list"
    }

    /**
    * <p>
    * 增加 测试 数据的表单
    * </p>
    *
    * @author yangguo
    * @since 2019-07-22
    */
    @GetMapping("/add")
    fun add(m: Model): Any {
        //
        val data = Test()
        m.set("data", data)

        return "$BasePath/add"
    }

    /**
    * <p>
    * 获取 测试 的数据
    * </p>
    *
    * @author yangguo
    * @since 2019-07-22
    */
    @GetMapping("/get")
    @ResponseBody
    fun get(m: Model, id: Int): Any {
        //
        return testService.getById(id)
    }
    /**
    * <p>
    * 增加记录到 测试 表中
    * </p>
    *
    * @author yangguo
    * @since 2019-07-22
    */
    @PostMapping("/add-save")
    fun addSave(m: Model, test: Test): Any {

        testService.save(test)

        return "redirect:/$BasePath/list"
    }

    /**
    * <p>
    * 编辑 测试 的表单
    * </p>
    *
    * @author yangguo
    * @since 2019-07-22
    */
    @GetMapping("/edit")
    fun edit(m: Model, id: Int?): Any {

        //
        val data = testService.getById(id ?: 1)
        m.set("data", data)

        return "$BasePath/edit"
    }

    /**
    * <p>
    * 保存记录到 测试
    * </p>
    *
    * @author yangguo
    * @since 2019-07-22
    */
    @PostMapping("/edit-save")
    fun editSave(m: Model, test: Test): Any {

        testService.updateById(test)

        return "redirect:/$BasePath/list"
    }

    /**
    * <p>
    * 删除 测试表中的记录
    * </p>
    *
    * @author yangguo
    * @since 2019-07-22
    */
    @GetMapping("/del")
    fun del(m: Model, id: Int?): Any {
        id ?: return "redirect:/$BasePath/list"

        val datas = testService.removeById(id)
        m.set("datas", datas)

        return "redirect:/$BasePath/list"
    }
}
