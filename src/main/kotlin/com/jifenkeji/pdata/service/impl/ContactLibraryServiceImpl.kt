package com.jifenkeji.pdata.service.impl;

import com.jifenkeji.pdata.entity.ContactLibrary;
import com.jifenkeji.pdata.mapper.ContactLibraryMapper;
import com.jifenkeji.pdata.service.IContactLibraryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 触点库 服务实现类
 * </p>
 *
 * @author yangguo
 * @since 2019-07-22
 */
@Service
open class ContactLibraryServiceImpl : ServiceImpl<ContactLibraryMapper, ContactLibrary>(), IContactLibraryService {

}
