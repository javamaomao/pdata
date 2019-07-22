package com.jifenkeji.pdata.entity

import com.baomidou.mybatisplus.annotation.TableName
import java.io.Serializable
/**
 * <p>
 * 
 * </p>
 *
 * @author yangguo
 * @since 2019-07-08
 */
@TableName("tb_admin_group")
class AdminGroup : Serializable {

    companion object {

        private const val serialVersionUID = 1L
    }
    var id: Int? = null

    var groupId: Int? = null

    var groupName: String? = null

    var groupAuth: String? = null

    var groupStatus :String?=null


    override fun toString(): String {
        return "AdminGroup{" +
        "groupId=" + groupId +
        ", groupName=" + groupName +
        ", groupAuth=" + groupAuth +
         ", groupStatus=" + groupStatus +
        "}"
    }
}
