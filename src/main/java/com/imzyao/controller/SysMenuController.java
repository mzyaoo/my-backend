package com.imzyao.controller;

import com.imzyao.modules.entity.SysMenu;
import com.imzyao.results.Result;
import com.imzyao.service.ISysMenuService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("menu")
public class SysMenuController {

    @Resource
    private ISysMenuService sysMenuService;

    @PostMapping("list")
    public Result<SysMenu> list() {
        return new Result<>();
    }

    @PostMapping("add")
    public Result<?> add() {
        return new Result<>();
    }


    @PostMapping("update")
    public Result<?> update() {
        return new Result<>();
    }


    @PostMapping("delete")
    public Result<?> delete() {
        return new Result<>();
    }

}
