package com.imzyao.service.impl;

import com.imzyao.enums.ResponseCode;
import com.imzyao.modules.model.LoginModel;
import com.imzyao.modules.entity.SysUser;
import com.imzyao.mappers.SysUserMapper;
import com.imzyao.modules.dto.LoginVO;
import com.imzyao.modules.pojo.SysUserInfo;
import com.imzyao.security.entity.CustomUserDetails;
import com.imzyao.service.ISysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imzyao.utils.JwtTokenUtil;
import com.imzyao.utils.ThrowUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author imzyao
 * @since 2024-07-29
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Resource
    private JwtTokenUtil tokenUtil;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Override
    public LoginVO login(LoginModel loginModel) {
        // 用户名
        String username = loginModel.getUsername();
        // 用户输入的密码
        String userInputPwd = loginModel.getPassword();
        // 获取用户信息
        UserDetails userDetails = loadUserByUsername(username);
        // 数据库中的用户密码
        String password = userDetails.getPassword();
        // 校验密码是否正确
        ThrowUtils.throwIf(!passwordEncoder.matches(userInputPwd, password), ResponseCode.SYSTEM_ERROR, "密码错误！");
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, null);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        String token = tokenUtil.generateToken(userDetails);
        return new LoginVO(token, tokenHead, tokenHeader);
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        SysUserInfo userInfo = getUserInfo(username);
        ThrowUtils.throwIf(userInfo == null, ResponseCode.NOT_FOUND_ERROR, "用户不存在！");
        return new CustomUserDetails(userInfo);
    }

    @Override
    public SysUserInfo getUserInfo(String username) {
        return this.baseMapper.getUserInfoByName(username);
    }

}
