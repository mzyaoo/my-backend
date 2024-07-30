package com.imzyao.security.config;

import com.imzyao.security.JwtAuthenticationTokenFilter;
import com.imzyao.security.RestAuthenticationEntryPoint;
import com.imzyao.security.RestfulAccessDeniedHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class DefaultSecurityConfig {

    @Resource
    private JwtAuthenticationTokenFilter tokenFilter;

    @Resource
    private RestfulAccessDeniedHandler restfulAccessDeniedHandler;

    @Resource
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity
                // 过滤请求
                .authorizeRequests()
                // 接口放行
                .antMatchers(
                        "/login",
                        "/webjars/**",
                        "/v3/api-docs",
                        "/v2/api-docs",
                        "/swagger-resources",
                        "/favicon.ico",
                        "/doc.html"
                ).permitAll()
                // 除上面外的所有请求全部需要鉴权认证
                .anyRequest()
                .authenticated()
                .and()
                // CSRF禁用
                .csrf().disable()
                // 禁用HTTP响应标头
                .headers().cacheControl().disable()
                // 自定义权限拒绝处理类
                .and()
                .exceptionHandling()
                // 自定义未授权处理类
                .accessDeniedHandler(restfulAccessDeniedHandler)
                // 自定义未登录处理类
                .authenticationEntryPoint(restAuthenticationEntryPoint)
                .and()
                // 基于JWT令牌，无需Session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                // 拦截器
                .addFilterBefore(tokenFilter, UsernamePasswordAuthenticationFilter.class);

        return httpSecurity.build();
    }


    /**
     * 获取AuthenticationManager（认证管理器），登录时认证使用
     *
     * @param authConfig
     * @return
     * @throws Exception
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

}
