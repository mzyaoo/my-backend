package com.imzyao.mappers;

import com.imzyao.modules.entity.SysMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Set;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author imzyao
 * @since 2024-08-01
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    /**
     * 查询所有系统菜单
     *
     * @return
     */
    List<SysMenu> getSystemMenuList();

    /**
     * 查询所有按钮权限
     *
     * @return
     */
    List<SysMenu> getSystemPermissionList();

}
