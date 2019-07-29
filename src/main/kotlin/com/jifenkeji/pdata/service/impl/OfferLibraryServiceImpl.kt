package com.jifenkeji.pdata.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import com.baomidou.mybatisplus.core.metadata.IPage
import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import com.jifenkeji.pdata.entity.OfferLibrary;
import com.jifenkeji.pdata.mapper.OfferLibraryMapper;
import com.jifenkeji.pdata.service.IOfferLibraryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * offer库 服务实现类
 * </p>
 *
 * @author yangguo
 * @since 2019-07-22
 */
@Service
open class OfferLibraryServiceImpl : ServiceImpl<OfferLibraryMapper, OfferLibrary>(), IOfferLibraryService {

    override fun search(pageIndex: Long?, pageSize: Long?, name: String?): IPage<OfferLibrary> {

        val map= mapOf("offer_name" to name)
                return baseMapper.selectPage(Page<OfferLibrary>(pageIndex?:1,pageSize?:10),
                QueryWrapper<OfferLibrary>().allEq(map,false))



    }
}
