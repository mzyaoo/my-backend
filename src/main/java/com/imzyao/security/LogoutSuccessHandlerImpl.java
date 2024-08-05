package com.imzyao.security;

import cn.hutool.json.JSONUtil;
import com.imzyao.components.RedisCache;
import com.imzyao.enums.ResponseCode;
import com.imzyao.results.Result;
import com.imzyao.security.entity.CustomUserDetails;
import com.imzyao.utils.JwtTokenUtil;
import com.imzyao.utils.ServletUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 自定义退出处理类 返回成功
 */
@Component
public class LogoutSuccessHandlerImpl implements LogoutSuccessHandler {

    @Resource
    private JwtTokenUtil jwtTokenUtil;

    @Resource
    private RedisCache redisCache;

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        CustomUserDetails userDetails = jwtTokenUtil.getLoginUserFormToken(request);
        if (userDetails != null) {
            String name = userDetails.getSysUser().getUserName();
            redisCache.deleteObject(name);
        }
        ServletUtils.renderString(response, JSONUtil.parse(Result.success(null, "退出成功！")));
    }
}
