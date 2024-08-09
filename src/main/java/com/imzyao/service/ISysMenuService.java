package com.imzyao.service;

import com.imzyao.modules.dto.menu.SearchMenuTableParam;
import com.imzyao.modules.entity.SysMenu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.imzyao.modules.entity.SysUser;
import com.imzyao.modules.vo.RouterVO;

import java.security.Principal;
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
     * 获取菜单树
     * @return
     */
    List<SysMenu> getMenuTree(SearchMenuTableParam param);

    /**
     * 获取用户路由信息
     *
     * @param principal
     * @return
     */
    List<RouterVO> userRouterList(Principal principal);


    /**
     * 获取前端需要的路由信息
     *
     * @param menus
     * @return
     */
    List<RouterVO> buildRouterInfo(List<SysMenu> menus);

    /**
     * 获取系统菜单
     *
     * @return
     */
    List<SysMenu> getSystemMenuList();

    /**
     * 查询所有系统权限
     *
     * @return
     */
    List<SysMenu> getSystemPermissionList();

    /**
     * 查询表格数据
     *
     * @return
     */
    List<SysUser> queryTableList();


    /**
     * 新增数据
     *
     * @param sysUser
     */
    void add(SysUser sysUser);


    /**
     * 根据id修改数据
     *
     * @param sysUser
     */
    void editById(SysUser sysUser);

    /**
     * 根据id删除数据
     *
     * @param id
     */
    void deleteById(Integer id);


}
