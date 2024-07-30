package com.imzyao.security.entity;

import com.imzyao.modules.pojo.SysUserInfo;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Data
public class CustomUserDetails implements UserDetails {

    private final SysUserInfo sysUserInfo;

    private final List<GrantedAuthority> userPermission;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return userPermission;
    }

    @Override
    public String getPassword() {
        return sysUserInfo.getPassword();
    }

    @Override
    public String getUsername() {
        return sysUserInfo.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return sysUserInfo.getStatus().equals("1");
    }
}
