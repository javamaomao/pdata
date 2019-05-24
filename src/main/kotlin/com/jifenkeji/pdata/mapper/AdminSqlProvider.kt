package com.jifenkeji.pdata.mapper

import com.jifenkeji.pdata.entity.Admin
import org.apache.ibatis.jdbc.SQL

class AdminSqlProvider {

    fun insertSelective(record: Admin): String {
        val sql = SQL()
        sql.INSERT_INTO("tb_admin")

        if (record.id != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}")
        }

        if (record.userId != null) {
            sql.VALUES("user_id", "#{userId,jdbcType=VARCHAR}")
        }

        if (record.userName != null) {
            sql.VALUES("user_name", "#{userName,jdbcType=VARCHAR}")
        }

        if (record.userPassword != null) {
            sql.VALUES("user_password", "#{userPassword,jdbcType=VARCHAR}")
        }

        if (record.groupId != null) {
            sql.VALUES("group_id", "#{groupId,jdbcType=INTEGER}")
        }

        if (record.sex != null) {
            sql.VALUES("sex", "#{sex,jdbcType=BIT}")
        }

        if (record.tel != null) {
            sql.VALUES("tel", "#{tel,jdbcType=VARCHAR}")
        }

        return sql.toString()
    }

    fun updateByPrimaryKeySelective(record: Admin): String {
        val sql = SQL()
        sql.UPDATE("tb_admin")

        if (record.userId != null) {
            sql.SET("user_id = #{userId,jdbcType=VARCHAR}")
        }

        if (record.userName != null) {
            sql.SET("user_name = #{userName,jdbcType=VARCHAR}")
        }

        if (record.userPassword != null) {
            sql.SET("user_password = #{userPassword,jdbcType=VARCHAR}")
        }

        if (record.groupId != null) {
            sql.SET("group_id = #{groupId,jdbcType=INTEGER}")
        }

        if (record.sex != null) {
            sql.SET("sex = #{sex,jdbcType=BIT}")
        }

        if (record.tel != null) {
            sql.SET("tel = #{tel,jdbcType=VARCHAR}")
        }

        sql.WHERE("id = #{id,jdbcType=INTEGER}")

        return sql.toString()
    }
}