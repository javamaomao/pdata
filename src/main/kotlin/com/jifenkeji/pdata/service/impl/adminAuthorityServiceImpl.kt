package com.jifenkeji.pdata.service.impl

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import com.jifenkeji.pdata.entity.Admin
import com.jifenkeji.pdata.mapper.AdminMapper
import com.jifenkeji.pdata.service.IAdminService
import org.springframework.stereotype.Service

@Service
open class adminAuthorityServiceImpl : ServiceImpl<AdminMapper, Admin>() {
}