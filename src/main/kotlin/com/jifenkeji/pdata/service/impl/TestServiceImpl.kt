package com.jifenkeji.pdata.service.impl;

import com.jifenkeji.pdata.entity.Test;
import com.jifenkeji.pdata.mapper.TestMapper;
import com.jifenkeji.pdata.service.ITestService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 测试 服务实现类
 * </p>
 *
 * @author yangguo
 * @since 2019-07-22
 */
@Service
open class TestServiceImpl : ServiceImpl<TestMapper, Test>(), ITestService {

}
