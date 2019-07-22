package com.jifenkeji.pdata.entity

import com.baomidou.mybatisplus.annotation.*
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

    override fun toString(): String {
        return "Admin(authoritiesList=$authoritiesList, id=$id, userId=$userId, userName=$userName, userPassword=$userPassword, groupId=$groupId, groupName=$groupName, sex=$sex, tel=$tel, status=$status)"
    }

    //
    @TableField(exist = false)
    var authoritiesList: ArrayList<GrantedAuthority>? = null
    /**
     * id
     */
    @TableId(value = "id",type = IdType.AUTO)
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
    /*
    组名
     */
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
    /*
    状态
     */
    var status :String? =null




}
