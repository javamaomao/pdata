package com.jifenkeji.pdata.mapper

import java.io.Serializable

interface BaseMapper<T, ID : Serializable> {

    fun deleteByPrimaryKey(id: ID?): Int

    fun insert(record: T): Int

    fun insertSelective(record: T): Int

    fun selectByPrimaryKey(id: ID?): T?

    fun updateByPrimaryKeySelective(record: T): Int

    fun updateByPrimaryKey(record: T): Int

    fun selectAll(): List<T>
}
