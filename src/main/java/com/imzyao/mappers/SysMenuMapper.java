package com.imzyao.mappers;

import com.imzyao.modules.entity.SysMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 菜单权限表 Mapper 接口
 * </p>
 *
 * @author imzyao
 * @since 2024-07-29
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    /**
     * 查询用户菜单权限
     *
     * @param username
     * @return
     */
    List<SysMenu> selectUserMenu(String username);


    /**
     * 查询用户菜单权限
     *
     * @param username
     * @return
     */
    List<SysMenu> getUserMenu(String username);
}
