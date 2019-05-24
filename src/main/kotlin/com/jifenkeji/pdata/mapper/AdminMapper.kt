package com.jifenkeji.pdata.mapper

import com.gloyray.mgr.entity.Admin
import com.gloyray.mgr.mapper.BaseMapper
import org.apache.ibatis.annotations.*
import org.apache.ibatis.type.JdbcType

interface AdminMapper : BaseMapper<Admin, Int> {
    @Delete("delete from tb_admin", "where id = #{id,jdbcType=INTEGER}")
    override fun deleteByPrimaryKey(id: Int?): Int

    @Insert("insert into tb_admin (id, user_id, ", "user_name, user_password, ", "group_id, sex, tel)", "values (#{id,jdbcType=INTEGER}, #{userId,jdbcType=VARCHAR}, ", "#{userName,jdbcType=VARCHAR}, #{userPassword,jdbcType=VARCHAR}, ", "#{groupId,jdbcType=INTEGER}, #{sex,jdbcType=BIT}, #{tel,jdbcType=VARCHAR})")
    override fun insert(record: Admin): Int

    @InsertProvider(type = AdminSqlProvider::class, method = "insertSelective")
    override fun insertSelective(record: Admin): Int

    @Select("select", "id, user_id, user_name, user_password, group_id, sex, tel", "from tb_admin", "where id = #{id,jdbcType=INTEGER}")
    @Results(Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true), Result(column = "user_id", property = "userId", jdbcType = JdbcType.VARCHAR), Result(column = "user_name", property = "userName", jdbcType = JdbcType.VARCHAR), Result(column = "user_password", property = "userPassword", jdbcType = JdbcType.VARCHAR), Result(column = "group_id", property = "groupId", jdbcType = JdbcType.INTEGER), Result(column = "sex", property = "sex", jdbcType = JdbcType.BIT), Result(column = "tel", property = "tel", jdbcType = JdbcType.VARCHAR))
    override fun selectByPrimaryKey(id: Int?): Admin

    @Select("select", "id, user_id, user_name, user_password, group_id, sex, tel", "from tb_admin", "where user_id = #{userId,jdbcType=VARCHAR}")
    @Results(Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true), Result(column = "user_id", property = "userId", jdbcType = JdbcType.VARCHAR), Result(column = "user_name", property = "userName", jdbcType = JdbcType.VARCHAR), Result(column = "user_password", property = "userPassword", jdbcType = JdbcType.VARCHAR), Result(column = "group_id", property = "groupId", jdbcType = JdbcType.INTEGER), Result(column = "sex", property = "sex", jdbcType = JdbcType.BIT), Result(column = "tel", property = "tel", jdbcType = JdbcType.VARCHAR))
    fun selectByAdminId(userId: String): Admin

    @UpdateProvider(type = AdminSqlProvider::class, method = "updateByPrimaryKeySelective")
    override fun updateByPrimaryKeySelective(record: Admin): Int

    @Update("update tb_admin", "set user_id = #{userId,jdbcType=VARCHAR},", "user_name = #{userName,jdbcType=VARCHAR},", "user_password = #{userPassword,jdbcType=VARCHAR},", "group_id = #{groupId,jdbcType=INTEGER},", "sex = #{sex,jdbcType=BIT},", "tel = #{tel,jdbcType=VARCHAR}", "where id = #{id,jdbcType=INTEGER}")
    override fun updateByPrimaryKey(record: Admin): Int

    @Select("select", "id, user_id, user_name, user_password, group_id, sex, tel", "from tb_admin", "order by id desc")
    @Results(Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true), Result(column = "user_id", property = "userId", jdbcType = JdbcType.VARCHAR), Result(column = "user_name", property = "userName", jdbcType = JdbcType.VARCHAR), Result(column = "user_password", property = "userPassword", jdbcType = JdbcType.VARCHAR), Result(column = "group_id", property = "groupId", jdbcType = JdbcType.INTEGER), Result(column = "sex", property = "sex", jdbcType = JdbcType.BIT), Result(column = "tel", property = "tel", jdbcType = JdbcType.VARCHAR))
    override fun selectAll(): List<Admin>
}