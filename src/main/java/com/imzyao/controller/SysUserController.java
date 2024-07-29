package com.imzyao.controller;

import com.imzyao.modules.model.LoginModel;
import com.imzyao.modules.dto.LoginVO;
import com.imzyao.results.Result;
import com.imzyao.service.ISysUserService;
import org.springframework.security.authentication.AuthenticationManager;
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
@RestController
@RequestMapping("/user")
public class SysUserController {

    @Resource
    private AuthenticationManager authenticationManager;

    @Resource
    private ISysUserService sysUserService;

    /**
     * 登录接口
     *
     * @param loginModel 登录信息
     * @return 登录结果
     */
    @PostMapping("login")
    public Result<LoginVO> login(@RequestBody LoginModel loginModel) {
        return Result.success(sysUserService.login(loginModel));
    }

    /**
     * 用户信息
     * @return
     */
    @GetMapping("info")
    public Result<?> getUserInfo(){
        return Result.success();
    }

}
