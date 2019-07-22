package com.jifenkeji.pdata.controller;

import com.jifenkeji.pdata.entity.ChannelLibrary
import com.jifenkeji.pdata.service.IChannelLibraryService
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
 * 渠道库 前端控制器
 * </p>
 *
 * @author yangguo
 * @since 2019-07-22
 */
@Controller
@RequestMapping("/channel-library")
class ChannelLibraryController {
    val BasePath = "channel-library"

    @Resource
    lateinit var channelLibraryService: IChannelLibraryService

    /**
    * <p>
    * 显示 渠道库 中所有项目
    * </p>
    *
    * @author yangguo
    * @since 2019-07-22
    */
    @GetMapping("/", "", "list")
    fun list(m: Model, page: Long?, size: Long?): Any {

        val datas = channelLibraryService.page(Page<ChannelLibrary>(page ?: 1, size ?: 10), null)

        m.set("datas", datas)
        return "$BasePath/list"
    }

    /**
    * <p>
    * 增加 渠道库 数据的表单
    * </p>
    *
    * @author yangguo
    * @since 2019-07-22
    */
    @GetMapping("/add")
    fun add(m: Model): Any {
        //
        val data = ChannelLibrary()
        m.set("data", data)

        return "$BasePath/add"
    }

    /**
    * <p>
    * 获取 渠道库 的数据
    * </p>
    *
    * @author yangguo
    * @since 2019-07-22
    */
    @GetMapping("/get")
    @ResponseBody
    fun get(m: Model, id: Int): Any {
        //
        return channelLibraryService.getById(id)
    }
    /**
    * <p>
    * 增加记录到 渠道库 表中
    * </p>
    *
    * @author yangguo
    * @since 2019-07-22
    */
    @PostMapping("/add-save")
    fun addSave(m: Model, channelLibrary: ChannelLibrary): Any {

        channelLibraryService.save(channelLibrary)

        return "redirect:/$BasePath/list"
    }

    /**
    * <p>
    * 编辑 渠道库 的表单
    * </p>
    *
    * @author yangguo
    * @since 2019-07-22
    */
    @GetMapping("/edit")
    fun edit(m: Model, id: Int?): Any {

        //
        val data = channelLibraryService.getById(id ?: 1)
        m.set("data", data)

        return "$BasePath/edit"
    }

    /**
    * <p>
    * 保存记录到 渠道库
    * </p>
    *
    * @author yangguo
    * @since 2019-07-22
    */
    @PostMapping("/edit-save")
    fun editSave(m: Model, channelLibrary: ChannelLibrary): Any {

        channelLibraryService.updateById(channelLibrary)

        return "redirect:/$BasePath/list"
    }

    /**
    * <p>
    * 删除 渠道库表中的记录
    * </p>
    *
    * @author yangguo
    * @since 2019-07-22
    */
    @GetMapping("/del")
    fun del(m: Model, id: Int?): Any {
        id ?: return "redirect:/$BasePath/list"

        val datas = channelLibraryService.removeById(id)
        m.set("datas", datas)

        return "redirect:/$BasePath/list"
    }
}
