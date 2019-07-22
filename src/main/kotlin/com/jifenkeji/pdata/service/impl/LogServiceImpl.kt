package com.jifenkeji.pdata.service.impl;

import com.jifenkeji.pdata.entity.Log;
import com.jifenkeji.pdata.mapper.LogMapper;
import com.jifenkeji.pdata.service.ILogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 日志 服务实现类
 * </p>
 *
 * @author yangguo
 * @since 2019-07-22
 */
@Service
open class LogServiceImpl : ServiceImpl<LogMapper, Log>(), ILogService {

}
