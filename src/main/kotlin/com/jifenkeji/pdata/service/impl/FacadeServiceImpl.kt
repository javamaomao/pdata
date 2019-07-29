package com.jifenkeji.pdata.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import com.baomidou.mybatisplus.core.metadata.IPage
import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import com.jifenkeji.pdata.entity.Facade;
import com.jifenkeji.pdata.mapper.FacadeMapper;
import com.jifenkeji.pdata.service.IFacadeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 门面 服务实现类
 * </p>
 *
 * @author yangguo
 * @since 2019-07-22
 */
@Service
open class FacadeServiceImpl : ServiceImpl<FacadeMapper, Facade>(), IFacadeService {
    override fun search(pageIndex: Long?, pageSize: Long?, storecode: String?, storename: String?): IPage<Facade> {

        val map= mapOf("store_code" to storecode,"name_of_store" to storename)
       return  baseMapper.selectPage(Page<Facade>(pageIndex?:1,pageSize?:10),
               QueryWrapper<Facade>().allEq(map,false))

    }
}
