package com.jifenkeji.pdata.service;

import com.baomidou.mybatisplus.core.metadata.IPage
import com.jifenkeji.pdata.entity.Admin;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yangguo
 * @since 2019-07-08
 */
interface IAdminService : IService<Admin> {
    fun findRolesByAdminId(username: String): List<String>?
    fun selectPageVo(pageIndex: Long?, pageSize: Long?, state: Int?): IPage<Admin>
}
