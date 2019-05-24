package com.jifenkeji.pdata.service.imp

import com.jifenkeji.pdata.service.AdminService
import org.apache.logging.log4j.LogManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import java.util.*


@Service
class CustomAdminDetailsService : UserDetailsService {

    @Autowired
    internal var adminService: AdminService? = null

    internal var logger = LogManager.getLogger(CustomAdminDetailsService::class.java)
    /**
     * 自定义管理员登录
     */
    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String): UserDetails {
        logger.info("获取管理员信息-->管理员名为:$username")
        val user = adminService!!.findByAdminId(username)
        if (user == null) {
            logger.info("获取管理员信息" + username + "失败")
            throw UsernameNotFoundException("管理员名：" + username + "不存在")
        }
        val authorities = ArrayList<GrantedAuthority>()
        val roleList = adminService!!.findRolesByAdminId(username)

        for (role in roleList!!) {
            logger.info("获取管理员权限-->" + role["role_code"])
            val authority = SimpleGrantedAuthority(role["role_code"])
            authorities.add(authority)
        }
        // 保存权限信息
        user.authoritiesList = authorities

        logger.info("获取管理员" + username + "信息成功！")
        return user
    }

}