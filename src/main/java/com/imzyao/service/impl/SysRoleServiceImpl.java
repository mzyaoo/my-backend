package com.imzyao.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.imzyao.enums.ResponseCode;
import com.imzyao.mappers.SysRoleMenuMapper;
import com.imzyao.modules.dto.role.AddRoleParam;
import com.imzyao.modules.dto.role.EditRoleParam;
import com.imzyao.modules.dto.role.RoleAuthParam;
import com.imzyao.modules.dto.role.SearchRoleTableParam;
import com.imzyao.modules.entity.SysRole;
import com.imzyao.mappers.SysRoleMapper;
import com.imzyao.modules.entity.SysRoleMenu;
import com.imzyao.modules.entity.SysUser;
import com.imzyao.modules.vo.RoleAuthVO;
import com.imzyao.service.ISysRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imzyao.utils.StringUtils;
import com.imzyao.utils.ThrowUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.security.Principal;
import java.time.LocalDateTime;
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

    @Resource
    private SysRoleMenuMapper sysRoleMenuMapper;

    @Override
    public IPage<SysRole> queryTableList(SearchRoleTableParam param) {
        long current = param.getCurrent();
        long pageSize = param.getPageSize();
        Page<SysRole> page = new Page<>(current, pageSize);
        LambdaQueryWrapper<SysRole> queryWrapper = new QueryWrapper<SysRole>().lambda();
        String roleName = param.getRoleName();
        queryWrapper.like(StringUtils.isNotEmpty(roleName), SysRole::getName, roleName);
        return this.page(page, queryWrapper);
    }

    @Override
    public void add(AddRoleParam param, Principal principal) {

        // 操作人
        String userName = principal.getName();

        // 参数信息
        String name = param.getName();
        Integer status = param.getStatus();
        List<Long> menuIds = param.getMenuIds();
        // 参数校验
        ThrowUtils.throwIf(StringUtils.isEmpty(name), ResponseCode.SYSTEM_ERROR, "角色名称不能为空！");
        ThrowUtils.throwIf(status == null, ResponseCode.SYSTEM_ERROR, "角色状态不能为空！");
        ThrowUtils.throwIf(CollectionUtil.isEmpty(menuIds), ResponseCode.SYSTEM_ERROR, "请选择角色对应菜单权限！");
        SysRole sysRole = new SysRole();
        BeanUtil.copyProperties(param, sysRole);
        sysRole.setDelFlag("0");
        sysRole.setCreateBy(userName);
        sysRole.setUpdateBy(userName);
        // 角色信息入库
        this.baseMapper.insert(sysRole);
        Integer id = sysRole.getId();

        // 角色菜单信息入库
        for (Long menuId : menuIds) {
            SysRoleMenu sysRoleMenu = new SysRoleMenu();
            sysRoleMenu.setRoleId(Long.parseLong(id.toString()));
            sysRoleMenu.setMenuId(menuId);
            sysRoleMenuMapper.insert(sysRoleMenu);
        }

    }

    @Override
    public void editById(EditRoleParam param, Principal principal) {

        // 操作人
        String userName = principal.getName();

        // 参数信息
        String name = param.getName();
        Integer status = param.getStatus();
        List<Long> menuIds = param.getMenuIds();
        // 参数校验
        ThrowUtils.throwIf(StringUtils.isNull(name), ResponseCode.SYSTEM_ERROR, "角色名称不能为空！");
        ThrowUtils.throwIf(status == null, ResponseCode.SYSTEM_ERROR, "角色状态不能为空！");
        ThrowUtils.throwIf(CollectionUtil.isEmpty(menuIds), ResponseCode.SYSTEM_ERROR, "请选择角色对应菜单权限！");
        SysRole sysRole = new SysRole();
        BeanUtil.copyProperties(param, sysRole);
        sysRole.setUpdateBy(userName);
        sysRole.setUpdateTime(LocalDateTime.now());

        // 角色信息入库
        this.baseMapper.updateById(sysRole);
        Integer id = sysRole.getId();

        // 删除所有角色菜单信息
        QueryWrapper<SysRoleMenu> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(SysRoleMenu::getRoleId, id);
        sysRoleMenuMapper.delete(queryWrapper);

        // 角色菜单信息重新入库
        for (Long menuId : menuIds) {
            SysRoleMenu sysRoleMenu = new SysRoleMenu();
            sysRoleMenu.setRoleId(Long.parseLong(id.toString()));
            sysRoleMenu.setMenuId(menuId);
            sysRoleMenuMapper.insert(sysRoleMenu);
        }

    }

    @Override
    public void deleteById(Integer id, Principal principal) {
        String userName = principal.getName();

        // 逻辑删除
        SysRole sysRole = new SysRole();
        sysRole.setId(id);
        sysRole.setDelFlag("1");
        sysRole.setUpdateBy(userName);
        // 删除角色信息
        this.baseMapper.updateById(sysRole);

    }

    @Override
    public void auth(RoleAuthParam param, Principal principal) {

        // 操作人
        principal.getName();

        Integer roleId = param.getRoleId();
        Long[] menuIds = param.getMenuIds();

        // 参数校验，不通过抛出异常
        ThrowUtils.throwIf(roleId == null, ResponseCode.SYSTEM_ERROR, "角色ID不能为空！");
        ThrowUtils.throwIf(menuIds.length == 0, ResponseCode.SYSTEM_ERROR, "请选择角色对应菜单权限！");

        // 删除所有角色菜单信息
        QueryWrapper<SysRoleMenu> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(SysRoleMenu::getRoleId, roleId);
        sysRoleMenuMapper.delete(queryWrapper);

        for (Long menuId : menuIds) {
            SysRoleMenu sysRoleMenu = new SysRoleMenu();
            sysRoleMenu.setRoleId(Long.parseLong(roleId.toString()));
            sysRoleMenu.setMenuId(menuId);
            sysRoleMenuMapper.insert(sysRoleMenu);
        }

    }

    @Override
    public RoleAuthVO getRoleAuth(Integer roleId) {

        ThrowUtils.throwIf(roleId == null, ResponseCode.SYSTEM_ERROR, "角色状态不能为空！");

        SysRole role = this.getById(roleId);
        ThrowUtils.throwIf(role == null, ResponseCode.SYSTEM_ERROR, "角色信息获取失败！");

        return new RoleAuthVO();
    }


}
