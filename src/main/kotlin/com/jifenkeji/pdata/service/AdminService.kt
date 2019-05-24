package com.jifenkeji.pdata.service

import com.gloyray.mgr.service.BaseService
import com.jifenkeji.pdata.entity.Admin

interface AdminService : BaseService<Admin, Int> {
    fun findByAdminId(adminId: String): Admin?
    fun findRolesByAdminId(adminId: String): List<Map<String,String>>?
}