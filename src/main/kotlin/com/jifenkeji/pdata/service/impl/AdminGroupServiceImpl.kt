package com.jifenkeji.pdata.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage
import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import com.jifenkeji.pdata.entity.AdminGroup;
import com.jifenkeji.pdata.mapper.AdminGroupMapper;
import com.jifenkeji.pdata.service.IAdminGroupService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource

/**
 * <p>
 *  服务实现类
 * </p>
 * @author yangguo
 * @since 2019-07-08
 *
 */


@Service
open class AdminGroupServiceImpl : ServiceImpl<AdminGroupMapper, AdminGroup>(), IAdminGroupService {



    override fun selectPage(pageIndex: Long?, pageSize: Long?): IPage<AdminGroup> {
        return baseMapper.selectPage(Page<AdminGroup>(pageIndex ?: 1, pageSize ?: 20), null)
    }


}
