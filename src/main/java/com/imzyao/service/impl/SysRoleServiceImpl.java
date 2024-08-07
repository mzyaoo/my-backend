package com.imzyao.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.imzyao.modules.dto.SearchRoleTableParam;
import com.imzyao.modules.entity.SysRole;
import com.imzyao.mappers.SysRoleMapper;
import com.imzyao.modules.entity.SysUser;
import com.imzyao.service.ISysRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imzyao.utils.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * <p>
 * 系统角色表 服务实现类
 * </p>
 *
 * @author imzyao
 * @since 2024-08-06
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {

    @Override
    public IPage<SysRole> queryTableList(SearchRoleTableParam param) {
        long current = param.getCurrent();
        long pageSize = param.getPageSize();
        Page<SysRole> page = new Page<>(current, pageSize);
        LambdaQueryWrapper<SysRole> queryWrapper = new QueryWrapper<SysRole>().lambda();
        String roleName = param.getRoleName();
        queryWrapper.eq(StringUtils.isNotEmpty(roleName), SysRole::getName, roleName);
        return this.page(page, queryWrapper);
    }

    @Override
    public void add(SysUser sysUser) {

    }

    @Override
    public void editById(SysUser sysUser) {

    }

    @Override
    public void deleteById(Integer id) {

    }
}
