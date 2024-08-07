package com.imzyao.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.imzyao.components.RedisCache;
import com.imzyao.constant.RedisConstants;
import com.imzyao.constant.UserConstants;
import com.imzyao.enums.ResponseCode;
import com.imzyao.mappers.SysMenuMapper;
import com.imzyao.modules.dto.SearchUserTableParam;
import com.imzyao.modules.entity.SysMenu;
import com.imzyao.modules.entity.SysUser;
import com.imzyao.modules.vo.UserInfoVO;
import com.imzyao.modules.dto.LoginParam;
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
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
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

    @Value("${jwt.expiration}")
    private Long expiration;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Resource
    private SysMenuMapper sysMenuMapper;

    @Resource
    private RedisCache redisCache;


    /**
     * 登录
     *
     * @param loginParam 登录参数
     * @return
     */
    @Override
    public LoginVO login(LoginParam loginParam) {
        // 用户名
        String username = loginParam.getUsername();
        // 用户输入的密码
        String userInputPwd = loginParam.getPassword();
        // 获取用户信息
        CustomUserDetails userDetails = loadUserByUsername(username);
        // 数据库中的用户密码
        String password = userDetails.getPassword();
        // 校验密码是否正确
        ThrowUtils.throwIf(!passwordEncoder.matches(userInputPwd, password), ResponseCode.SYSTEM_ERROR, "密码错误！");
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, null);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        String token = tokenUtil.generateToken(userDetails);


        String loginKey = RedisConstants.getLoginKey(username);
        redisCache.setCacheObject(loginKey, userDetails, expiration, TimeUnit.SECONDS);

        return new LoginVO(token, tokenHead, tokenHeader);
    }

    /**
     * 加载至 Security 用户信息
     *
     * @param username 用户名
     * @return
     */
    @Override
    public CustomUserDetails loadUserByUsername(String username) {
        SysUser sysUser = getUserInfo(username);
        ThrowUtils.throwIf(sysUser == null, ResponseCode.NOT_FOUND_ERROR, "用户名或密码错误！");
        // 校验用户是否被删除
        boolean userDelFlag = StringUtils.equals(sysUser.getDelFlag(), "1");
        ThrowUtils.throwIf(userDelFlag, ResponseCode.NOT_FOUND_ERROR, "该账户已删除！");

        boolean userStatus = StringUtils.equals(sysUser.getStatus(), "1");
        ThrowUtils.throwIf(userStatus, ResponseCode.NOT_FOUND_ERROR, "该账户已封禁！");

        List<GrantedAuthority> userPermission = new ArrayList<>();
        List<SysMenu> menus = new ArrayList<>();

        if (username.equals(UserConstants.SYSTEM_SUP_USER)) {
            // 超级管理员 权限
            menus = sysMenuMapper.getSystemPermissionList();
        } else {
            // 用户权限
            menus = Collections.emptyList();
        }

        List<String> collect = menus.stream().map(SysMenu::getPerms).collect(Collectors.toList());
        for (String authority : collect) {
            if (StringUtils.isNotEmpty(authority)) {
                GrantedAuthority auth = new SimpleGrantedAuthority(authority);
                userPermission.add(auth);
            }
        }
        return new CustomUserDetails(sysUser, userPermission);
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
        userInfoVO.setUserId(user.getId());
        userInfoVO.setNickName(user.getNickName());
        userInfoVO.setAvatar(user.getAvatar());

        if (name.equals(UserConstants.SYSTEM_SUP_USER)) {
            List<String> perms = sysMenuMapper.getSystemPermissionList()
                    .stream().map(SysMenu::getPerms).collect(Collectors.toList());
            userInfoVO.setPermissions(perms);
        }

        return userInfoVO;
    }

    @Override
    public IPage<SysUser> queryTableList(SearchUserTableParam param) {
        long current = param.getCurrent();
        long pageSize = param.getPageSize();
        Page<SysUser> page = new Page<>(current, pageSize);
        LambdaQueryWrapper<SysUser> queryWrapper = new QueryWrapper<SysUser>().lambda();
        return this.page(page, queryWrapper);
    }

    @Override
    public void add(SysUser sysUser) {
        this.save(sysUser);
    }

    @Override
    public void editById(SysUser sysUser) {
        this.updateById(sysUser);
    }

    @Override
    public void deleteById(Integer id) {

    }


}
