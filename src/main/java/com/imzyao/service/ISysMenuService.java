package com.imzyao.service;

import com.imzyao.modules.entity.SysMenu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.imzyao.modules.vo.RouterVo;

import java.util.List;

/**
 * <p>
 * 菜单权限表 服务类
 * </p>
 *
 * @author imzyao
 * @since 2024-07-29
 */
public interface ISysMenuService extends IService<SysMenu> {

    /**
     * 查询用户菜单权限
     *
     * @param username 用户名
     * @return
     */
    List<SysMenu> getUserMenu(String username);


    /**
     * 构建前端菜单
     *
     * @param menus
     * @return
     */
    List<RouterVo> buildMenus(List<SysMenu> menus);

}
