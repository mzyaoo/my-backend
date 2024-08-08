package com.imzyao.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.imzyao.modules.dto.SearchUserTableParam;
import com.imzyao.modules.entity.SysUser;
import com.imzyao.results.Result;
import com.imzyao.service.ISysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author imzyao
 * @since 2024-07-29
 */
@Api
@RestController
@RequestMapping("/user")
public class SysUserController {

    @Resource
    private ISysUserService sysUserService;

    /**
     * 用户列表
     *
     * @return
     */
    @GetMapping("list")
//    @PreAuthorize("hasAnyAuthority('system:user:list')")
    @ApiOperation("获取用户列表")
    public Result<IPage<SysUser>> list(SearchUserTableParam param) {
        IPage<SysUser> iPage = sysUserService.queryTableList(param);
        return Result.success(iPage);
    }


    @PostMapping("add")
    public Result<?> add(SysUser sysUser) {
        sysUserService.add(sysUser);
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
