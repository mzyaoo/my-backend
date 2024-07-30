package com.imzyao.controller;

import com.imzyao.modules.entity.SysMenu;
import com.imzyao.modules.vo.LoginVO;
import com.imzyao.modules.vo.RouterVo;
import com.imzyao.modules.vo.UserInfoVO;
import com.imzyao.modules.model.LoginModel;
import com.imzyao.results.Result;
import com.imzyao.service.ISysMenuService;
import com.imzyao.service.ISysUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.security.Principal;
import java.util.List;

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
     * @param loginModel 登录信息
     * @return 登录结果
     */
    @PostMapping("login")
    public Result<LoginVO> login(@RequestBody LoginModel loginModel) {
        return Result.success(sysUserService.login(loginModel));
    }

    /**
     * 用户信息
     *
     * @return
     */
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
    @PostMapping("getUserMenu")
    public Result<List<RouterVo>> getUserMenu(Principal principal) {
        String username = principal.getName();
        List<SysMenu> menu = sysMenuService.getUserMenu(username);
        return Result.success(sysMenuService.buildMenus(menu));
    }

}
