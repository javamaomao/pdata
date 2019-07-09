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


    var groupId: Int? = null

    var groupName: String? = null

    var groupAuth: String? = null


    override fun toString(): String {
        return "AdminGroup{" +
        "groupId=" + groupId +
        ", groupName=" + groupName +
        ", groupAuth=" + groupAuth +
        "}"
    }
}
