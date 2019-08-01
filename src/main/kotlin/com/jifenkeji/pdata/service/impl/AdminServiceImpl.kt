package com.jifenkeji.pdata.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import com.jifenkeji.pdata.entity.Admin;
import com.jifenkeji.pdata.mapper.AdminMapper;
import com.jifenkeji.pdata.service.IAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage
import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import com.jifenkeji.pdata.entity.AdminRole
import com.jifenkeji.pdata.mapper.AdminRoleMapper
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
    lateinit var  adminRoleMapper :AdminRoleMapper

    @Resource
    lateinit var adminMapper :AdminMapper
    //
    override fun selectPage(pageIndex: Long?, pageSize: Long?): IPage<Admin> {
        return baseMapper.selectPage(Page<Admin>(pageIndex ?: 1, pageSize ?: 10), null)
    }


    override fun findRolesByAdminId(username: String): List<String>? {
         val admin=baseMapper.selectOne(QueryWrapper<Admin>().apply{eq("user_id",username)})
        val adminRole=adminRoleMapper.selectOne(QueryWrapper<AdminRole>().apply{eq("id",admin.groupId)})
        val list =adminRole.roleAuth?.split(',')
        return list

        //
    }


    override fun searchpage(pageIndex: Long?, pageSize: Long? ,words :String?):IPage<Admin>{
        return baseMapper.selectPage(Page<Admin>(pageIndex ?: 1, pageSize ?: 10),
                QueryWrapper<Admin>().apply{ like("user_name",words).or().like("user_id",words)})
    }


    /*override fun s(pageIndex: Long?, pageSize: Long?): IPage<Admin> {
              return  adminMapper.se()
        // IPage<T> selectPage(IPage<T> page, @Param(Constants.WRAPPER) Wrapper<T> queryWrapper);
       // return baseMapper.selectPage(Page<Admin>(pageIndex ?: 1, pageSize ?: 20), null)
    }*/
    override fun se(): Admin {
        return adminMapper.se()
    }


    override fun updateByidSta(admin: Admin?) {
        adminMapper.updateByidSta(admin)
    }
}
