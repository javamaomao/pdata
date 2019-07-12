package com.jifenkeji.pdata.entity

import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableName
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.io.Serializable
import java.util.ArrayList
/**
 * <p>
 * 
 * </p>
 *
 * @author yangguo
 * @since 2019-07-08
 */
@TableName("tb_admin")
class Admin : UserDetails {

    companion object {

        private const val serialVersionUID = 2322301147368384299L
    }

    override fun getAuthorities(): ArrayList<GrantedAuthority>? {
        return authoritiesList
    }


    override fun isEnabled(): Boolean {
        return true
    }

    override fun getUsername(): String {
        return this.userName!!
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun getPassword(): String {
        return userPassword!!
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    //
    @TableField(exist = false)
    var authoritiesList: ArrayList<GrantedAuthority>? = null
    /**
     * id
     */
    var id: Int? = null
    /**
     * 用户id
     */
    var userId: String? = null

    /**
     * 用户昵称
     */
    var userName: String? = null

    /**
     * 用户密码
     */
    var userPassword: String? = null

    /**
     * 组id
     */
    var groupId: Int? = null

    @TableField(exist = false)
    var groupName: String? = null
    /**
     * 性别
     */
    var sex: Boolean? = null

    /**
     * 电话
     */
    var tel: String? = null



    override fun toString(): String {
        return "Admin{" +
        "userId=" + userId +
        ", userName=" + userName +
        ", userPassword=" + userPassword +
        ", groupId=" + groupId +
        ", sex=" + sex +
        ", tel=" + tel +
        "}"
    }
}
