package com.jifenkeji.pdata.service.impl;

import com.jifenkeji.pdata.entity.RightsManagement;
import com.jifenkeji.pdata.mapper.RightsManagementMapper;
import com.jifenkeji.pdata.service.IRightsManagementService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 权限管理 服务实现类
 * </p>
 *
 * @author yangguo
 * @since 2019-07-08
 */
@Service
open class RightsManagementServiceImpl : ServiceImpl<RightsManagementMapper, RightsManagement>(), IRightsManagementService {

}
