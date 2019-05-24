package com.jifenkeji.pdata.service

import com.gloyray.mgr.entity.Admin
import com.gloyray.mgr.service.BaseService

interface AdminService : BaseService<Admin, Int> {
    fun findByAdminId(adminId: String): Admin?
    fun findRolesByAdminId(adminId: String): List<Map<String,String>>?
}