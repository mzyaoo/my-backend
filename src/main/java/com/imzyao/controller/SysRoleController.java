package com.imzyao.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.imzyao.modules.dto.SearchRoleTableParam;
import com.imzyao.modules.entity.SysRole;
import com.imzyao.results.Result;
import com.imzyao.service.ISysRoleService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api
@RestController
@RequestMapping("role")
public class SysRoleController {

    @Resource
    private ISysRoleService sysRoleService;

    @PostMapping("list")
    public Result<IPage<SysRole>> list(SearchRoleTableParam param) {
        IPage<SysRole> iPage = sysRoleService.queryTableList(param);
        return Result.success(iPage);
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
