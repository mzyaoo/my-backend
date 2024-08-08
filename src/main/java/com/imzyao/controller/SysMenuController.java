package com.imzyao.controller;

import com.imzyao.modules.dto.SearchMenuTableParam;
import com.imzyao.modules.entity.SysMenu;
import com.imzyao.results.Result;
import com.imzyao.service.ISysMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Api
@RestController
@RequestMapping("menu")
public class SysMenuController {

    @Resource
    private ISysMenuService sysMenuService;

    /**
     * 获取所有菜单权限列表
     *
     * @return
     */
    @PostMapping("list")
    @ApiOperation("获取所有菜单权限列表")
    public Result<List<SysMenu>> list(SearchMenuTableParam param) {
        List<SysMenu> tree = sysMenuService.getMenuTree(param);
        return Result.success(tree);
    }

    /**
     * 获取所有菜单权限tree结构
     *
     * @return
     */
    @ApiOperation("获取所有菜单权限tree结构")
    @GetMapping("tree")
    public Result<List<SysMenu>> tree() {
        // 只查询启用的菜单/权限
        SearchMenuTableParam param = new SearchMenuTableParam();
        param.setStatus(0);
        List<SysMenu> tree = sysMenuService.getMenuTree(param);
        return Result.success(tree);
    }

    @PostMapping("add")
    public Result<?> add() {
        return Result.success();
    }


    @PostMapping("update")
    public Result<?> update() {
        return Result.success();
    }


    @PostMapping("delete")
    public Result<?> delete() {
        return Result.success();
    }

}
