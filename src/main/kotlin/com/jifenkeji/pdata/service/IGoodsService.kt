package com.jifenkeji.pdata.service;

import com.baomidou.mybatisplus.core.metadata.IPage
import com.jifenkeji.pdata.entity.Goods;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jifenkeji.pdata.entity.AdminRole
import com.jifenkeji.pdata.entity.LibraryOfGoods

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yangguo
 * @since 2019-07-22
 */
interface IGoodsService : IService<Goods>{
    fun selectPage(pageIndex: Long?, pageSize: Long?): IPage<LibraryOfGoods>


}
