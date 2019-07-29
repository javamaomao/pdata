package com.jifenkeji.pdata.service;

import com.baomidou.mybatisplus.core.metadata.IPage
import com.jifenkeji.pdata.entity.LibraryOfGoods;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jifenkeji.pdata.entity.AdminRole

/**
 * <p>
 * 商品库 服务类
 * </p>
 *
 * @author yangguo
 * @since 2019-07-22
 */
interface ILibraryOfGoodsService : IService<LibraryOfGoods> {

    fun selectPage(pageIndex: Long?, pageSize: Long?,goodscat:String?,goodsname:String?): IPage<LibraryOfGoods>
}
