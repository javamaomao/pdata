package com.jifenkeji.pdata.entity

import com.baomidou.mybatisplus.annotation.TableName
import java.io.Serializable

@TableName("tb_admin_authority")
class AdminAuthority :Serializable {

    companion object {

        private const val serialVersionUID = 2322301147368384299L
    }

    var id: Int? = null

    var authId: String? =null

    var authName: String? = null

    override fun toString(): String {
        return "AdminAuthority(id=$id, authId=$authId, authName=$authName)"
    }

}