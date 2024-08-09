package com.imzyao.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.imzyao.modules.dto.role.AddRoleParam;
import com.imzyao.modules.dto.role.EditRoleParam;
import com.imzyao.modules.dto.role.RoleAuthParam;
import com.imzyao.modules.dto.role.SearchRoleTableParam;
import com.imzyao.modules.entity.SysRole;
import com.imzyao.modules.vo.RoleAuthVO;
import com.imzyao.results.Result;
import com.imzyao.service.ISysRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.security.Principal;

/**
 * 角色相关接口开发
 */
@Api
@RestController
@RequestMapping("role")
public class SysRoleController {

    // 后台权限校验注解，功能完成后再开启
    // @PreAuthorize("hasAnyAuthority('system:user:list')")

    @Resource
    private ISysRoleService sysRoleService;

    @PostMapping("list")
    @ApiOperation("获取角色列表")
    public Result<IPage<SysRole>> list(@RequestBody SearchRoleTableParam param) {
        IPage<SysRole> iPage = sysRoleService.queryTableList(param);
        return Result.success(iPage);
    }

    @PostMapping("add")
    @ApiOperation("新增角色")
    public Result<?> add(@RequestBody AddRoleParam param, Principal principal) {
        sysRoleService.add(param, principal);
        return Result.success();
    }


    @PostMapping("auth")
    @ApiOperation("角色授权")
    public Result<?> auth(@RequestBody RoleAuthParam param, Principal principal) {
        sysRoleService.auth(param, principal);
        return Result.success();
    }


    @PostMapping("update")
    @ApiOperation("修改角色")
    public Result<?> update(@RequestBody EditRoleParam param, Principal principal) {
        sysRoleService.editById(param, principal);
        return Result.success();
    }


    @PostMapping("delete")
    @ApiOperation("删除角色（逻辑删除）")
    public Result<?> delete(Integer id, Principal principal) {
        sysRoleService.deleteById(id, principal);
        return Result.success();
    }

    @PostMapping("getRoleAuth")
    @ApiOperation("获取用户角色权限")
    public Result<RoleAuthVO> getRoleAuth(Integer roleId) {
        RoleAuthVO data = sysRoleService.getRoleAuth(roleId);
        return Result.success(data);
    }


}
