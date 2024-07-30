package com.imzyao.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.imzyao.enums.ResponseCode;
import com.imzyao.mappers.SysMenuMapper;
import com.imzyao.modules.vo.UserInfoVO;
import com.imzyao.modules.entity.SysMenu;
import com.imzyao.modules.model.LoginModel;
import com.imzyao.modules.entity.SysUser;
import com.imzyao.mappers.SysUserMapper;
import com.imzyao.modules.vo.LoginVO;
import com.imzyao.modules.pojo.SysUserInfo;
import com.imzyao.security.entity.CustomUserDetails;
import com.imzyao.service.ISysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imzyao.utils.JwtTokenUtil;
import com.imzyao.utils.ThrowUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @Resource
    private SysMenuMapper sysMenuMapper;

    /**
     * 登录
     * @param loginModel 登录参数
     * @return
     */
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

    /**
     * 加载至 Security 用户信息
     * @param username 用户名
     * @return
     */
    @Override
    public UserDetails loadUserByUsername(String username) {
        SysUserInfo userInfo = getUserInfo(username);
        ThrowUtils.throwIf(userInfo == null, ResponseCode.NOT_FOUND_ERROR, "用户不存在！");

        List<SysMenu> permissionList = sysMenuMapper.selectUserMenu(userInfo.getUserName());

        List<GrantedAuthority> userPermission = new ArrayList<>();
        List<String> collect = permissionList.stream().map(SysMenu::getPerms).collect(Collectors.toList());
        for (String authority : collect) {
            if (!("").equals(authority) & authority != null) {
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority);
                userPermission.add(grantedAuthority);
            }
        }
        return new CustomUserDetails(userInfo, userPermission);
    }

    /**
     * 根据用户名查看用户信息
     * @param username
     * @return
     */
    @Override
    public SysUserInfo getUserInfo(String username) {
        return this.baseMapper.getUserInfoByName(username);
    }

    /**
     * 获取登录用户信息
     * @param principal
     * @return
     */
    @Override
    public UserInfoVO getLoginInfo(Principal principal) {
        UserInfoVO userInfoVO = new UserInfoVO();
        String name = principal.getName();
        SysUserInfo user = this.baseMapper.getUserInfoByName(name);
        ThrowUtils.throwIf(user == null, ResponseCode.SYSTEM_ERROR, "用户信息获取失败！");
        BeanUtil.copyProperties(user, userInfoVO);
        return userInfoVO;
    }

}
