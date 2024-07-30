package com.imzyao.controller;

import com.imzyao.results.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("menu")
public class SysMenuController {

    @PostMapping("list")
    public Result<?> list() {
        return new Result<>();
    }

}
