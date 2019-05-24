package com.jifenkeji.pdata.entity

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class Admin : UserDetails {
    //
    var authoritiesList: MutableCollection<out GrantedAuthority>? = null

    override fun getAuthorities(): MutableCollection<out GrantedAuthority>? {
        return authoritiesList
    }

    override fun isEnabled(): Boolean {
        return true
    }

    override fun getUsername(): String? {
        return this.userName
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun getPassword(): String? {
        return this.userPassword
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    var id: Int? = null

    var userId: String? = null
        set(userId) {
            field = userId?.trim { it <= ' ' }
        }

    var userName: String? = null
        set(userName) {
            field = userName?.trim { it <= ' ' }
        }

    var userPassword: String? = null
        set(userPassword) {
            field = userPassword?.trim { it <= ' ' }
        }

    var groupId: Int? = null

    var sex: Boolean? = null

    var tel: String? = null
        set(tel) {
            field = tel?.trim { it <= ' ' }
        }

    companion object {

        private const val serialVersionUID = 1L
    }
}