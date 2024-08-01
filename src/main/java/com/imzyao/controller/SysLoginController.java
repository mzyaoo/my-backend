package com.imzyao.controller;

import com.imzyao.modules.entity.SysMenu;
import com.imzyao.modules.vo.LoginVO;
import com.imzyao.modules.vo.RouterVo;
import com.imzyao.modules.vo.UserInfoVO;
import com.imzyao.modules.model.LoginModel;
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
     * @param loginModel 登录信息
     * @return 登录结果
     */
    @ApiOperation("登录")
    @PostMapping("login")
    public Result<LoginVO> login(@RequestBody LoginModel loginModel) {
        return Result.success(sysUserService.login(loginModel));
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
    public Result<List<RouterVo>> getUserMenu(Principal principal) {
        String username = principal.getName();
        List<SysMenu> menuList = sysMenuService.getSystemMenuList();

//        String json = "[\n" +
//                "  {\n" +
//                "    \"path\": \"/system\",\n" +
//                "    \"name\": \"系统管理\",\n" +
//                "    \"children\": [\n" +
//                "      {\n" +
//                "        \"path\": \"/user\",\n" +
//                "        \"name\": \"用户管理\",\n" +
//                "        \"component\": \"system/user/index\",\n" +
//                "        \"meta\": {\n" +
//                "          \"sort\": 1\n" +
//                "        }\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"path\": \"/dept\",\n" +
//                "        \"name\": \"部门管理\",\n" +
//                "        \"component\": \"system/dept/index\",\n" +
//                "        \"meta\": {\n" +
//                "          \"sort\": 2\n" +
//                "        }\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"path\": \"/role\",\n" +
//                "        \"name\": \"角色管理\",\n" +
//                "        \"component\": \"system/role/index\",\n" +
//                "        \"meta\": {\n" +
//                "          \"sort\": 3\n" +
//                "        }\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"path\": \"/menu\",\n" +
//                "        \"name\": \"菜单管理\",\n" +
//                "        \"component\": \"system/menu/index\",\n" +
//                "        \"meta\": {\n" +
//                "          \"sort\": 4\n" +
//                "        }\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"path\": \"/job\",\n" +
//                "        \"name\": \"定时任务配置\",\n" +
//                "        \"component\": \"system/job/index\",\n" +
//                "        \"meta\": {\n" +
//                "          \"sort\": 4\n" +
//                "        }\n" +
//                "      }\n" +
//                "    ],\n" +
//                "    \"meta\": {\n" +
//                "      \"sort\": 2,\n" +
//                "      \"icon\": \"IconSettings\"\n" +
//                "    }\n" +
//                "  }\n" +
//                "]";
//
//        JSONArray objects = JSON.parseArray(json);

        return Result.success(sysMenuService.buildRouterInfo(menuList));
    }

}
