package com.jifenkeji.pdata.service.impl;

import com.jifenkeji.pdata.entity.Facade;
import com.jifenkeji.pdata.mapper.FacadeMapper;
import com.jifenkeji.pdata.service.IFacadeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 门面 服务实现类
 * </p>
 *
 * @author yangguo
 * @since 2019-07-22
 */
@Service
open class FacadeServiceImpl : ServiceImpl<FacadeMapper, Facade>(), IFacadeService {

}
