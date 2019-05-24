package com.gloyray.mgr.service

import com.github.pagehelper.Page
import com.github.pagehelper.PageInfo

import java.io.Serializable

interface BaseService<T, ID : Serializable> {

    fun removeByPrimaryKey(id: ID): Boolean

    fun add(record: T): Boolean

    fun addSelective(record: T): Boolean

    fun findByPrimaryKey(id: ID): T?

    fun saveByPrimaryKeySelective(record: T): Boolean

    fun saveByPrimaryKey(record: T): Boolean

    fun findAll(): List<T>

    fun findPage(pageNum: Int, pageSize: Int): Page<T>

}
