package com.jifenkeji.pdata.service;

import com.baomidou.mybatisplus.core.metadata.IPage
import com.jifenkeji.pdata.entity.ContactLibrary;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 触点库 服务类
 * </p>
 *
 * @author yangguo
 * @since 2019-07-22
 */
interface IContactLibraryService : IService<ContactLibrary>{
    fun search(pageIndex:Long?,pageSize:Long?,name:String?):IPage<ContactLibrary>
}
