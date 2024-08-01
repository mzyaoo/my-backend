package com.imzyao.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.imzyao.constant.UserConstants;
import com.imzyao.enums.ResponseCode;
import com.imzyao.mappers.SysUserMapper;
import com.imzyao.modules.entity.SysMenu;
import com.imzyao.mappers.SysMenuMapper;
import com.imzyao.modules.entity.SysUser;
import com.imzyao.modules.vo.MetaVo;
import com.imzyao.modules.vo.RouterVo;
import com.imzyao.results.Result;
import com.imzyao.service.ISysMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imzyao.service.ISysUserService;
import com.imzyao.utils.ThrowUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.security.Principal;
import java.util.*;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author imzyao
 * @since 2024-08-01
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements ISysMenuService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public List<RouterVo> userRouterList(Principal principal) {
        String username = principal.getName();
        SysUser sysUser = sysUserMapper.selectByUserName(username);
        // 校验用户是否存在，不存在抛出异常
        ThrowUtils.throwIf(sysUser == null, ResponseCode.NOT_FOUND_ERROR, "用户不存在！");
        // 校验用户是否为超级管理员，是则返回所有菜单
        List<SysMenu> menuList = new ArrayList<>();
        if (sysUser.getUserName().equals(UserConstants.SYSTEM_SUP_USER)) {
            menuList = this.getSystemMenuList();
        } else {
            menuList = Collections.emptyList();
        }
        return buildRouterInfo(menuList);
    }

    @Override
    public List<RouterVo> buildRouterInfo(List<SysMenu> menus) {

        List<RouterVo> routers = new ArrayList<>();
        for (SysMenu menu : menus) {
            RouterVo router = new RouterVo();
            router.setPath(menu.getPath());
            router.setComponent(menu.getComponent());
            router.setName(menu.getName());
            router.setSort(menu.getOrderNum());
            MetaVo meta = genMetaFormMenu(menu);
            router.setMeta(meta);
            if (CollectionUtil.isNotEmpty(menu.getChildren())) {
                router.setChildren(buildRouterInfo(menu.getChildren()));
            }
            routers.add(router);
        }
        return routers;
    }

    @Override
    public List<SysMenu> getSystemMenuList() {
        List<SysMenu> menuList = this.baseMapper.getSystemMenuList();
        return getChildPerms(menuList, 0);
    }

    @Override
    public List<SysMenu> getSystemPermissionList() {
        return this.baseMapper.getSystemPermissionList();
    }

    /**
     * 根据父节点的ID获取所有子节点
     *
     * @param list     分类表
     * @param parentId 传入的父节点ID
     * @return String
     */
    public List<SysMenu> getChildPerms(List<SysMenu> list, int parentId) {
        List<SysMenu> returnList = new ArrayList<SysMenu>();
        for (Iterator<SysMenu> iterator = list.iterator(); iterator.hasNext(); ) {
            SysMenu t = (SysMenu) iterator.next();
            // 一、根据传入的某个父节点ID,遍历该父节点的所有子节点
            if (t.getParentId() == parentId) {
                recursionFn(list, t);
                returnList.add(t);
            }
        }
        return returnList;
    }


    /**
     * 递归列表
     *
     * @param list 分类表
     * @param t    子节点
     */
    private void recursionFn(List<SysMenu> list, SysMenu t) {
        // 得到子节点列表
        List<SysMenu> childList = getChildList(list, t);
        t.setChildren(childList);
        for (SysMenu tChild : childList) {
            if (hasChild(list, tChild)) {
                recursionFn(list, tChild);
            }
        }
    }

    /**
     * 判断是否有子节点
     */
    private boolean hasChild(List<SysMenu> list, SysMenu t) {
        return !getChildList(list, t).isEmpty();
    }


    /**
     * 得到子节点列表
     */
    private List<SysMenu> getChildList(List<SysMenu> list, SysMenu t) {
        List<SysMenu> tlist = new ArrayList<SysMenu>();
        Iterator<SysMenu> it = list.iterator();
        while (it.hasNext()) {
            SysMenu n = (SysMenu) it.next();
            if (n.getParentId().longValue() == t.getId().longValue()) {
                tlist.add(n);
            }
        }
        return tlist;
    }

    private MetaVo genMetaFormMenu(SysMenu menu) {
        MetaVo meta = new MetaVo();
        meta.setIcon(menu.getIcon());
        meta.setHidden(menu.getVisible().equals("1"));
        return meta;
    }
}
