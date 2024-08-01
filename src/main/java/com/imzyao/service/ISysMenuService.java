package com.imzyao.service;

import com.imzyao.modules.entity.SysMenu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.imzyao.modules.vo.RouterVo;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author imzyao
 * @since 2024-08-01
 */
public interface ISysMenuService extends IService<SysMenu> {

    /**
     * 获取前端需要的路由信息
     * @param menus
     * @return
     */
    List<RouterVo> buildRouterInfo(List<SysMenu> menus);

    /**
     * 获取系统菜单
     * @return
     */
    List<SysMenu> getSystemMenuList();

}
