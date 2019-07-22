package com.jifenkeji.pdata.service

import com.baomidou.mybatisplus.core.metadata.IPage
import com.baomidou.mybatisplus.extension.service.IService
import com.jifenkeji.pdata.entity.AdminGroup
import com.jifenkeji.pdata.entity.AdminRole

interface IAdminRoleService  : IService<AdminRole>{
    fun selectPage(pageIndex: Long?, pageSize: Long?): IPage<AdminRole>
    fun search(pageIndex: Long?,pageSize: Long?,words:String?) :IPage<AdminRole>
}