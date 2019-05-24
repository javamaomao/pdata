package com.jifenkeji.pdata.service.imp

import com.gloyray.mgr.service.impl.BaseServiceImpl
import com.jifenkeji.pdata.entity.Admin
import com.jifenkeji.pdata.mapper.AdminGroupMapper
import com.jifenkeji.pdata.mapper.AdminMapper
import com.jifenkeji.pdata.service.AdminService
import org.springframework.stereotype.Service
import javax.annotation.Resource

@Service
class AdminServiceImpl : BaseServiceImpl<Admin, Int>(), AdminService {
    @Resource
    override val mapper: AdminMapper? = null
    @Resource
    val adminGroupMapper: AdminGroupMapper? = null

    //
    override fun findByAdminId(adminId: String): Admin? {
        return mapper?.selectByAdminId(adminId)
    }

    //
    override fun findRolesByAdminId(adminId: String): List<Map<String, String>>? {
        val admin = mapper?.selectByAdminId(adminId)
        admin ?: return null
        admin.groupId ?: return null
        //
        val adminGroup = adminGroupMapper?.selectByGroupID(admin.groupId!!)
        adminGroup ?: return null
        adminGroup.groupAuth ?: return null

        return adminGroup.groupAuth!!.split(",").fold(mutableListOf<Map<String,String>>()) { r, acc->
            r.apply {
                r.add(mapOf("role_code" to acc))
            }
        }
    }

}
