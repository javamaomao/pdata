package com.jifenkeji.pdata.service;

import com.baomidou.mybatisplus.core.metadata.IPage
import com.jifenkeji.pdata.entity.Facade;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 门面 服务类
 * </p>
 *
 * @author yangguo
 * @since 2019-07-22
 */
interface IFacadeService : IService<Facade>{
    fun search(pageIndex:Long?,pageSize:Long?,storecode:String?,storename:String?):IPage<Facade>
}
