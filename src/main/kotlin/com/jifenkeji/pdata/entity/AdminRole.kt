package com.jifenkeji.pdata.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.io.Serializable

@TableName("tb_admin_role")
class AdminRole  : Serializable{

    companion object {

        private const val serialVersionUID = 2322301147368384299L
    }

    @TableId(value = "id",type = IdType.AUTO)
    var id: Int? = null

    var roleId: Int? = null

    var roleName: String? = null

    var roleAuth: String? = null

    override fun toString(): String {
        return "AdminRole(id=$id, roleId=$roleId, roleName=$roleName, roleAuth=$roleAuth)"
    }


}


