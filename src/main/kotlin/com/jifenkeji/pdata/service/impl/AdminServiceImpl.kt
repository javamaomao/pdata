package com.jifenkeji.pdata.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import com.jifenkeji.pdata.entity.Admin;
import com.jifenkeji.pdata.mapper.AdminMapper;
import com.jifenkeji.pdata.service.IAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage
import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import com.jifenkeji.pdata.entity.AdminGroup
import com.jifenkeji.pdata.mapper.AdminGroupMapper
import org.springframework.beans.BeanUtils
import javax.annotation.Resource


/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yangguo
 * @since 2019-07-08
 */
@Service
open class AdminServiceImpl : ServiceImpl<AdminMapper, Admin>(), IAdminService {
    //
    @Resource
    lateinit var adminGroupMapper: AdminGroupMapper
    //
    override fun selectPage(pageIndex: Long?, pageSize: Long?): IPage<Admin> {
        return baseMapper.selectPage(Page<Admin>(pageIndex ?: 1, pageSize ?: 20), null)
    }


    //
    override fun findRolesByAdminId(username: String): List<String>? {
        val admin = baseMapper.selectOne(QueryWrapper<Admin>().apply { eq("user_id", username) })
        //
        val adminGroup = adminGroupMapper.selectOne(QueryWrapper<AdminGroup>().apply { eq("group_id", admin.groupId) })
        val list = adminGroup.groupAuth?.split('|')

        return list
    }


    override fun searchpage(pageIndex: Long?, pageSize: Long? ,words :String?):IPage<Admin>{


        return baseMapper.selectPage(Page<Admin>(pageIndex ?: 1, pageSize ?: 20),
                QueryWrapper<Admin>().apply{ like("user_name",words).or().like("user_id",words)})
    }




}
