package com.jifenkeji.pdata.service.impl

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import com.jifenkeji.pdata.entity.AdminAuthority
import com.jifenkeji.pdata.mapper.AdminAuthorityMapper
import com.jifenkeji.pdata.service.IAdminAuthorityService
import org.springframework.stereotype.Service

@Service
open class AdminAuthorityServiceImpl :ServiceImpl<AdminAuthorityMapper,AdminAuthority>(),IAdminAuthorityService {

}