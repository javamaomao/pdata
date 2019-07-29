package com.jifenkeji.pdata.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import com.baomidou.mybatisplus.core.metadata.IPage
import com.baomidou.mybatisplus.extension.plugins.pagination.Page
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
    override fun selectPage(pageIndex: Long?, pageSize: Long?,goodscat:String?,goodsname:String?): IPage<LibraryOfGoods> {



        val map= mapOf("trade_name" to goodsname)
        val map1= mapOf("first_class_classification" to goodscat)
        val map2= mapOf("secondary_classification_of_goods" to goodscat)
        val map3= mapOf("three_level_commodity_classification" to goodscat)
        return baseMapper.selectPage(Page<LibraryOfGoods>(pageIndex ?:1,pageSize ?:10),
                QueryWrapper<LibraryOfGoods>().apply{allEq(map,false).allEq(map1,false).
                        or().allEq(map2,false).or().allEq(map3,false)})
    }
}
