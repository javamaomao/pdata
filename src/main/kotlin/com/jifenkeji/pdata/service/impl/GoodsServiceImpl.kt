package com.jifenkeji.pdata.service.impl;

import com.jifenkeji.pdata.entity.Goods;
import com.jifenkeji.pdata.mapper.GoodsMapper;
import com.jifenkeji.pdata.service.IGoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yangguo
 * @since 2019-07-22
 */
@Service
open class GoodsServiceImpl : ServiceImpl<GoodsMapper, Goods>(), IGoodsService {

}
