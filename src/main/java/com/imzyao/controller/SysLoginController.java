package com.imzyao.controller;

import com.imzyao.modules.vo.LoginVO;
import com.imzyao.modules.vo.RouterVO;
import com.imzyao.modules.vo.UserInfoVO;
import com.imzyao.modules.dto.login.LoginParam;
import com.imzyao.results.Result;
import com.imzyao.service.ISysMenuService;
import com.imzyao.service.ISysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.security.Principal;
import java.util.List;

@Api(value = "登录相关接口")
@RestController
@RequestMapping
public class SysLoginController {

    @Resource
    private ISysUserService sysUserService;

    @Resource
    private ISysMenuService sysMenuService;

    /**
     * 登录接口
     *
     * @param loginParam 登录信息
     * @return 登录结果
     */
    @ApiOperation("登录")
    @PostMapping("login")
    public Result<LoginVO> login(@RequestBody LoginParam loginParam) {
        return Result.success(sysUserService.login(loginParam));
    }

    /**
     * 用户信息
     *
     * @return
     */
    @ApiOperation("获取用户信息")
    @GetMapping("getUserInfo")
    public Result<UserInfoVO> getUserInfo(Principal principal) {
        UserInfoVO loginInfo = sysUserService.getLoginInfo(principal);
        return Result.success(loginInfo);
    }

    /**
     * 获取用户菜单信息
     *
     * @param principal
     * @return
     */
    @ApiOperation("查询用户菜单权限")
    @PostMapping("getUserMenu")
    public Result<List<RouterVO>> getUserMenu(Principal principal) {
        List<RouterVO> routerVOS = sysMenuService.userRouterList(principal);
        return Result.success(routerVOS);
    }

}
