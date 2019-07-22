package com.jifenkeji.pdata.service.impl

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import com.baomidou.mybatisplus.core.metadata.IPage
import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import com.jifenkeji.pdata.entity.Admin
import com.jifenkeji.pdata.entity.AdminRole
import com.jifenkeji.pdata.mapper.AdminMapper
import com.jifenkeji.pdata.mapper.AdminRoleMapper
import com.jifenkeji.pdata.service.IAdminRoleService
import com.jifenkeji.pdata.service.IAdminService
import org.springframework.stereotype.Service

@Service
open class AdminRoleServiceImpl : ServiceImpl<AdminRoleMapper, AdminRole>(), IAdminRoleService {
    override fun selectPage(pageIndex: Long?, pageSize: Long?): IPage<AdminRole> {
        return baseMapper.selectPage(Page<AdminRole>(pageIndex ?: 1, pageSize ?: 10), null)
    }

    override fun search(pageIndex: Long?, pageSize: Long?, words: String?): IPage<AdminRole> {
     //   TODO("not implemented")
        return baseMapper.selectPage(Page<AdminRole>(pageIndex ?:1,pageSize ?:10),
                QueryWrapper<AdminRole>().apply{ like("role_name",words)})
    }
}