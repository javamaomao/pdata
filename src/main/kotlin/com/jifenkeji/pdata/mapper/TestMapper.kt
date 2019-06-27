package com.jifenkeji.pdata.mapper

import com.jifenkeji.pdata.entity.Test
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Result
import org.apache.ibatis.annotations.Results
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.type.JdbcType

interface TestMapper : BaseMapper<Test, Int> {
    @Insert("insert into test (id, name)", "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR})")
    override fun insert(record: Test): Int

    @Select("select", "id, name", "from test", "order by id desc")
    @Results(Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER),
            Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR))
    override fun selectAll(): List<Test>
}