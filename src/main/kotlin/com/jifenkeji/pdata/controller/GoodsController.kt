package com.jifenkeji.pdata.controller;

import com.jifenkeji.pdata.entity.Goods
import com.jifenkeji.pdata.service.IGoodsService
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
 *  前端控制器
 * </p>
 *
 * @author yangguo
 * @since 2019-07-22
 */
@Controller
@RequestMapping("/goods")
class GoodsController {
    val BasePath = "goods"

    @Resource
    lateinit var goodsService: IGoodsService

    /**
    * <p>
    * 显示  中所有项目
    * </p>
    *
    * @author yangguo
    * @since 2019-07-22
    */
    @GetMapping("/", "", "list")
    fun list(m: Model, page: Long?, size: Long?): Any {

        val datas = goodsService.page(Page<Goods>(page ?: 1, size ?: 10), null)

        m.set("datas", datas)
        return "$BasePath/list"
    }

    /**
    * <p>
    * 增加  数据的表单
    * </p>
    *
    * @author yangguo
    * @since 2019-07-22
    */
    @GetMapping("/add")
    fun add(m: Model): Any {
        //
        val data = Goods()
        m.set("data", data)

        return "$BasePath/add"
    }

    /**
    * <p>
    * 获取  的数据
    * </p>
    *
    * @author yangguo
    * @since 2019-07-22
    */
    @GetMapping("/get")
    @ResponseBody
    fun get(m: Model, id: Int): Any {
        //
        return goodsService.getById(id)
    }
    /**
    * <p>
    * 增加记录到  表中
    * </p>
    *
    * @author yangguo
    * @since 2019-07-22
    */
    @PostMapping("/add-save")
    fun addSave(m: Model, goods: Goods): Any {

        goodsService.save(goods)

        return "redirect:/$BasePath/list"
    }

    /**
    * <p>
    * 编辑  的表单
    * </p>
    *
    * @author yangguo
    * @since 2019-07-22
    */
    @GetMapping("/edit")
    fun edit(m: Model, id: Int?): Any {

        //
        val data = goodsService.getById(id ?: 1)
        m.set("data", data)

        return "$BasePath/edit"
    }

    /**
    * <p>
    * 保存记录到 
    * </p>
    *
    * @author yangguo
    * @since 2019-07-22
    */
    @PostMapping("/edit-save")
    fun editSave(m: Model, goods: Goods): Any {

        goodsService.updateById(goods)

        return "redirect:/$BasePath/list"
    }

    /**
    * <p>
    * 删除 表中的记录
    * </p>
    *
    * @author yangguo
    * @since 2019-07-22
    */
    @GetMapping("/del")
    fun del(m: Model, id: Int?): Any {
        id ?: return "redirect:/$BasePath/list"

        val datas = goodsService.removeById(id)
        m.set("datas", datas)

        return "redirect:/$BasePath/list"
    }
}
