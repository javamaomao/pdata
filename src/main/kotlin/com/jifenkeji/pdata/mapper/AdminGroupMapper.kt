package com.jifenkeji.pdata.mapper

import com.jifenkeji.pdata.entity.AdminGroup
import org.apache.ibatis.annotations.*
import org.apache.ibatis.type.JdbcType

interface AdminGroupMapper : BaseMapper<AdminGroup, Int> {
    @Delete("delete from tb_admin_group", "where id = #{id,jdbcType=INTEGER}", "and group_id = #{groupId,jdbcType=INTEGER}")
    fun deleteByPrimaryKey(key: Int): Int

    @Insert("insert into tb_admin_group (id, group_id, ", "group_name, group_auth)", "values (#{id,jdbcType=INTEGER}, #{groupId,jdbcType=INTEGER}, ", "#{groupName,jdbcType=VARCHAR}, #{groupAuth,jdbcType=VARCHAR})")
    override fun insert(record: AdminGroup): Int

    @InsertProvider(type = AdminGroupSqlProvider::class, method = "insertSelective")
    override fun insertSelective(record: AdminGroup): Int

    @Select("select", "id, group_id, group_name, group_auth", "from tb_admin_group", "where id = #{id,jdbcType=INTEGER}", "and group_id = #{groupId,jdbcType=INTEGER}")
    @Results(Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true), Result(column = "group_id", property = "groupId", jdbcType = JdbcType.INTEGER, id = true), Result(column = "group_name", property = "groupName", jdbcType = JdbcType.VARCHAR), Result(column = "group_auth", property = "groupAuth", jdbcType = JdbcType.VARCHAR))
    fun selectByPrimaryKey(key: Int): AdminGroup

    @Select("select", "id, group_id, group_name, group_auth", "from tb_admin_group", "where group_id = #{groupId,jdbcType=INTEGER}")
    @Results(Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true), Result(column = "group_id", property = "groupId", jdbcType = JdbcType.INTEGER, id = true), Result(column = "group_name", property = "groupName", jdbcType = JdbcType.VARCHAR), Result(column = "group_auth", property = "groupAuth", jdbcType = JdbcType.VARCHAR))
    fun selectByGroupID(key: Int): AdminGroup

    @UpdateProvider(type = AdminGroupSqlProvider::class, method = "updateByPrimaryKeySelective")
    override fun updateByPrimaryKeySelective(record: AdminGroup): Int

    @Update("update tb_admin_group", "set group_name = #{groupName,jdbcType=VARCHAR},", "group_auth = #{groupAuth,jdbcType=VARCHAR}", "where id = #{id,jdbcType=INTEGER}", "and group_id = #{groupId,jdbcType=INTEGER}")
    override fun updateByPrimaryKey(record: AdminGroup): Int
}