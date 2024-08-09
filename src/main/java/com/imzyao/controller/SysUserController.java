package com.imzyao.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.imzyao.modules.dto.user.AddUserParam;
import com.imzyao.modules.dto.user.EditUserParam;
import com.imzyao.modules.dto.user.SearchUserTableParam;
import com.imzyao.modules.entity.SysUser;
import com.imzyao.results.Result;
import com.imzyao.service.ISysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.security.Principal;

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
    @PostMapping("list")
    @ApiOperation("获取用户列表")
    public Result<IPage<SysUser>> list(@RequestBody SearchUserTableParam param) {
        IPage<SysUser> iPage = sysUserService.queryTableList(param);
        return Result.success(iPage);
    }


    @PostMapping("add")
    @ApiOperation("添加用户")
    public Result<?> add(@RequestBody AddUserParam param, Principal principal) {
        sysUserService.add(param, principal);
        return Result.success();
    }


    @PostMapping("updateById")
    @ApiOperation("根据ID更新用户")
    public Result<?> updateById(@RequestBody EditUserParam param, Principal principal) {
        sysUserService.editById(param, principal);
        return Result.success();
    }


    @PostMapping("deleteById")
    @ApiOperation("根据ID删除用户（逻辑删除）")
    public Result<?> delete(Integer id, Principal principal) {
        sysUserService.deleteById(id, principal);
        return Result.success();
    }

}
