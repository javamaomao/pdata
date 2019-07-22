package com.jifenkeji.pdata.service.impl;

import com.jifenkeji.pdata.entity.LibraryOfGoods;
import com.jifenkeji.pdata.mapper.LibraryOfGoodsMapper;
import com.jifenkeji.pdata.service.ILibraryOfGoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品库 服务实现类
 * </p>
 *
 * @author yangguo
 * @since 2019-07-22
 */
@Service
open class LibraryOfGoodsServiceImpl : ServiceImpl<LibraryOfGoodsMapper, LibraryOfGoods>(), ILibraryOfGoodsService {

}
