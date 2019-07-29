package com.jifenkeji.pdata.service;

import com.baomidou.mybatisplus.core.metadata.IPage
import com.jifenkeji.pdata.entity.OfferLibrary;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * offer库 服务类
 * </p>
 *
 * @author yangguo
 * @since 2019-07-22
 */
interface IOfferLibraryService : IService<OfferLibrary>{
    fun search(pageIndex:Long?,pageSize:Long?,name:String?):IPage<OfferLibrary>
}
