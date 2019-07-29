package com.jifenkeji.pdata.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import com.baomidou.mybatisplus.core.metadata.IPage
import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import com.jifenkeji.pdata.entity.ChannelLibrary;
import com.jifenkeji.pdata.mapper.ChannelLibraryMapper;
import com.jifenkeji.pdata.service.IChannelLibraryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 渠道库 服务实现类
 * </p>
 *
 * @author yangguo
 * @since 2019-07-22
 */
@Service
open class ChannelLibraryServiceImpl : ServiceImpl<ChannelLibraryMapper, ChannelLibrary>(), IChannelLibraryService {

    override fun search(pageIndex: Long?, pageSize: Long?, cname: String?, ctype: String?): IPage<ChannelLibrary> {

        val map= mapOf("channel_name" to cname,"channel_type" to ctype)
        return baseMapper.selectPage(Page<ChannelLibrary>(pageIndex?:1,pageSize?:10),
                QueryWrapper<ChannelLibrary>().allEq(map,false))
        /*
          return  baseMapper.selectPage(Page<Facade>(pageIndex?:1,pageSize?:10),
               QueryWrapper<Facade>().allEq(map,false))
         */

    }
}
