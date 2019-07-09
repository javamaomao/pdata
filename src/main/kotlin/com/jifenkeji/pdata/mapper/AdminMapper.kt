package com.jifenkeji.pdata.mapper;

import com.jifenkeji.pdata.entity.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage
import com.baomidou.mybatisplus.extension.plugins.pagination.Page
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

    /**
     *
     *
     * 查询 : 根据state状态查询用户列表，分页显示
     * 注意!!: 如果入参是有多个,需要加注解指定参数名才能在xml中取值
     *
     *
     * @param page 分页对象,xml中可以从里面进行取值,传递参数 Page 即自动分页,必须放在第一位(你可以继承Page实现自己的分页对象)
     * @param state 状态
     * @return 分页对象
     */
    fun selectPageVo(page: Page<Admin>, @Param("state") state: Int?): IPage<Admin>
}
