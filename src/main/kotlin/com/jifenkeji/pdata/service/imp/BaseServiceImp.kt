package com.gloyray.mgr.service.impl

import com.github.pagehelper.Page
import com.github.pagehelper.PageHelper
import com.github.pagehelper.PageInfo
import com.gloyray.mgr.service.BaseService
import com.gloyray.mgr.mapper.BaseMapper
import org.springframework.stereotype.Service

import java.io.Serializable

@Service
abstract class BaseServiceImpl<T, ID : Serializable> : BaseService<T, ID> {

    abstract val mapper: BaseMapper<T, ID>?

    override fun removeByPrimaryKey(id: ID): Boolean {

        return mapper!!.deleteByPrimaryKey(id) > 0
    }

    override fun add(record: T): Boolean {
        return mapper!!.insert(record) > 0
    }

    override fun addSelective(record: T): Boolean {
        return mapper!!.insertSelective(record) > 0
    }

    override fun findByPrimaryKey(id: ID): T? {
        return mapper!!.selectByPrimaryKey(id)
    }

    override fun saveByPrimaryKeySelective(record: T): Boolean {

        return mapper!!.updateByPrimaryKeySelective(record) > 0
    }

    override fun saveByPrimaryKey(record: T): Boolean {
        return mapper!!.updateByPrimaryKey(record) > 0
    }

    override fun findAll(): List<T> {
        return mapper!!.selectAll()
    }

    override fun findPage(pageNum: Int, pageSize: Int): Page<T> {
        PageHelper.startPage<T>(pageNum, pageSize)
        val data = mapper!!.selectAll()
        //val pageInfo = PageInfo(data, pageSize);
        return data as Page<T>
    }
}
