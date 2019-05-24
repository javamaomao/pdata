package com.jifenkeji.pdata.mapper

import com.jifenkeji.pdata.entity.AdminGroup
import org.apache.ibatis.jdbc.SQL

class AdminGroupSqlProvider {

    fun insertSelective(record: AdminGroup): String {
        val sql = SQL()
        sql.INSERT_INTO("tb_admin_group")

        if (record.id != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}")
        }

        if (record.groupId != null) {
            sql.VALUES("group_id", "#{groupId,jdbcType=INTEGER}")
        }

        if (record.groupName != null) {
            sql.VALUES("group_name", "#{groupName,jdbcType=VARCHAR}")
        }

        if (record.groupAuth != null) {
            sql.VALUES("group_auth", "#{groupAuth,jdbcType=VARCHAR}")
        }

        return sql.toString()
    }

    fun updateByPrimaryKeySelective(record: AdminGroup): String {
        val sql = SQL()
        sql.UPDATE("tb_admin_group")

        if (record.groupName != null) {
            sql.SET("group_name = #{groupName,jdbcType=VARCHAR}")
        }

        if (record.groupAuth != null) {
            sql.SET("group_auth = #{groupAuth,jdbcType=VARCHAR}")
        }

        sql.WHERE("id = #{id,jdbcType=INTEGER}")
        sql.WHERE("group_id = #{groupId,jdbcType=INTEGER}")

        return sql.toString()
    }
}