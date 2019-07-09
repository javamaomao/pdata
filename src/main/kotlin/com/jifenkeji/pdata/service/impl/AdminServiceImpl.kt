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
    override fun findRolesByAdminId(username: String): List<String>? {
        val admin = baseMapper.selectOne(QueryWrapper<Admin>().apply { eq("user_name", username) })
        //
        val adminGroup = adminGroupMapper.selectOne(QueryWrapper<AdminGroup>().apply { eq("group_id", admin.groupId) })
        val list = adminGroup.groupAuth?.split('|')

        return list
    }

    /**
     * 查询角色列表(分页)
     *
     * @param roleParam 角色参数
     * @return 查询角色分页列表
     */
    override fun selectPageVo(pageIndex: Long?, pageSize: Long?, state: Int?): IPage<Admin> {
        val page = Page<Admin>(pageIndex ?: 1, pageSize ?: 10)
        return baseMapper.selectPageVo(page, state)
    }

    fun selectUserPage(page: Page<Admin>, state: Int?): IPage<Admin> {
        // 不进行 count sql 优化，解决 MP 无法自动优化 SQL 问题，这时候你需要自己查询 count 部分
        // page.setOptimizeCountSql(false);
        // 当 total 为非 0 时(默认为 0),分页插件不会进行 count 查询
        // 要点!! 分页返回的对象与传入的对象是同一个
        return baseMapper.selectPageVo(page,
                                       state)
    }
}
