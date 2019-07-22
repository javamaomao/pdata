package com.jifenkeji.pdata.service;

import com.baomidou.mybatisplus.core.metadata.IPage
import com.baomidou.mybatisplus.extension.service.IService
import com.jifenkeji.pdata.entity.AdminGroup
import com.jifenkeji.pdata.entity.C1

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yangguo
 * @since 2019-07-08
 */
interface IAdminGroupService : IService<AdminGroup> {
    fun selectPage(pageIndex: Long?, pageSize: Long?): IPage<AdminGroup>


}
