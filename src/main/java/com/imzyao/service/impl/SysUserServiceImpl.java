package com.imzyao.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.imzyao.enums.ResponseCode;
import com.imzyao.modules.entity.SysUser;
import com.imzyao.modules.vo.UserInfoVO;
import com.imzyao.modules.model.LoginModel;
import com.imzyao.mappers.SysUserMapper;
import com.imzyao.modules.vo.LoginVO;
import com.imzyao.security.entity.CustomUserDetails;
import com.imzyao.service.ISysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imzyao.utils.JwtTokenUtil;
import com.imzyao.utils.StringUtils;
import com.imzyao.utils.ThrowUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.security.Principal;
import java.util.ArrayList;

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


    /**
     * 登录
     *
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
     *
     * @param username 用户名
     * @return
     */
    @Override
    public UserDetails loadUserByUsername(String username) {
        SysUser sysUser = getUserInfo(username);
        ThrowUtils.throwIf(sysUser == null, ResponseCode.NOT_FOUND_ERROR, "用户名或密码错误！");
        // 校验用户是否被删除
        boolean userDelFlag = StringUtils.equals(sysUser.getDelFlag(), "1");
        ThrowUtils.throwIf(userDelFlag, ResponseCode.NOT_FOUND_ERROR, "该账户已删除！");

        boolean userStatus = StringUtils.equals(sysUser.getStatus(), "1");
        ThrowUtils.throwIf(userStatus, ResponseCode.NOT_FOUND_ERROR, "该账户已封禁！");

//        List<SysMenu> permissionList = sysMenuMapper.selectUserMenu(userInfo.getUserName());
//
//        List<GrantedAuthority> userPermission = new ArrayList<>();
//        List<String> collect = permissionList.stream().map(SysMenu::getPerms).collect(Collectors.toList());
//        for (String authority : collect) {
//            if (!("").equals(authority) & authority != null) {
//                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority);
//                userPermission.add(grantedAuthority);
//            }
//        }
        return new CustomUserDetails(sysUser, new ArrayList<>());
    }

    /**
     * 根据用户名查看用户信息
     *
     * @param username
     * @return
     */
    @Override
    public SysUser getUserInfo(String username) {
        LambdaQueryWrapper<SysUser> userQuery = new QueryWrapper<SysUser>().lambda();
        userQuery.eq(SysUser::getUserName, username);
        return this.baseMapper.selectOne(userQuery);
    }

    /**
     * 获取登录用户信息
     *
     * @param principal
     * @return
     */
    @Override
    public UserInfoVO getLoginInfo(Principal principal) {
        UserInfoVO userInfoVO = new UserInfoVO();
        String name = principal.getName();
        SysUser user = this.getUserInfo(name);
        ThrowUtils.throwIf(user == null, ResponseCode.SYSTEM_ERROR, "用户信息获取失败！");
        userInfoVO.setUserName(user.getUserName());

        return userInfoVO;
    }


}
