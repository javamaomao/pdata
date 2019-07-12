package com.jifenkeji.pdata.entity

import com.baomidou.mybatisplus.annotation.TableName
import java.io.Serializable
/**
 * <p>
 * 权限管理
 * </p>
 *
 * @author yangguo
 * @since 2019-07-08
 */
@TableName("tb_rights_management")
class RightsManagement : Serializable {


    /**
     * 权限ID
     */
    var authorizationId: String? = null
    /**
     * 权限名称
     */
    var permissionToName: String? = null

    /**
     * 权限图标
     */
    var permissionsOnIcon: String? = null

    /**
     * 权限地址
     */
    var permissionToAddress: String? = null


    override fun toString(): String {
        return "RightsManagement{" +
        "authorizationId=" + authorizationId +
        ", permissionToName=" + permissionToName +
        ", permissionsOnIcon=" + permissionsOnIcon +
        ", permissionToAddress=" + permissionToAddress +
        "}"
    }
}
