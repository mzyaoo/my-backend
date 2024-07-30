package com.imzyao.controller;

import com.imzyao.results.Result;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 用户列表
     *
     * @return
     */
    @GetMapping("list")
    @PreAuthorize("hasAnyAuthority('system:user:main')")
    public Result<?> list() {
        return Result.success();
    }

}
