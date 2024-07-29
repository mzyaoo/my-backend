package com.imzyao.service;

import com.imzyao.modules.model.LoginModel;
import com.imzyao.modules.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.imzyao.modules.dto.LoginVO;
import com.imzyao.modules.pojo.SysUserInfo;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author imzyao
 * @since 2024-07-29
 */
public interface ISysUserService extends IService<SysUser> {

    /**
     * 登录
     *
     * @param loginModel 登录参数
     * @return token
     */
    LoginVO login(LoginModel loginModel);

    /**
     * 根据用户名查询用户信息
     *
     * @param username 用户名
     * @return Security对象
     */
    UserDetails loadUserByUsername(String username);

    /**
     * 根据用户名查询用户信息
     *
     * @param username
     * @return
     */
    SysUserInfo getUserInfo(String username);

}
