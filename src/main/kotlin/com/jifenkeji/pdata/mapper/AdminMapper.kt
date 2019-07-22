package com.jifenkeji.pdata.mapper;

import com.jifenkeji.pdata.entity.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage
import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import com.jifenkeji.pdata.entity.AdminGroup
import io.lettuce.core.dynamic.annotation.Param


/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yangguo
 * @since 2019-07-08
 */
interface AdminMapper : BaseMapper<Admin> {

    fun ses(): IPage<Admin>
    //IPage<T> selectPage(IPage<T> page, @Param(Constants.WRAPPER) Wrapper<T> queryWrapper);
    //fun searchpage(pageIndex: Long?, pageSize: Long? ,words :String?):IPage<Admin>

    fun se():Admin

    fun updateByidSta(admin: Admin ?)


}


