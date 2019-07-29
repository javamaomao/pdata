package com.jifenkeji.pdata.service;

import com.baomidou.mybatisplus.core.metadata.IPage
import com.jifenkeji.pdata.entity.ChannelLibrary;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 渠道库 服务类
 * </p>
 *
 * @author yangguo
 * @since 2019-07-22
 */
interface IChannelLibraryService : IService<ChannelLibrary>{
    fun search(pageIndex:Long?,pageSize:Long?,cname:String?,ctype:String?):IPage<ChannelLibrary>
}
