package com.jifenkeji.pdata.service;

import com.baomidou.mybatisplus.core.metadata.IPage
import com.baomidou.mybatisplus.extension.service.IService;
import com.jifenkeji.pdata.entity.Admin

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
    fun selectPage(pageIndex: Long?, pageSize: Long?): IPage<Admin>

    fun searchpage(pageIndex: Long?, pageSize: Long? ,words :String?):IPage<Admin>


}
