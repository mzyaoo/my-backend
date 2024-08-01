package com.imzyao.security.entity;

import com.imzyao.modules.entity.SysUser;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
public class CustomUserDetails implements UserDetails {

    private final SysUser sysUser;

    private final List<GrantedAuthority> userPermission;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return userPermission;
    }

    @Override
    public String getPassword() {
        return sysUser.getPassWord();
    }

    @Override
    public String getUsername() {
        return sysUser.getUserName();
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
        return sysUser.getStatus().equals("1");
    }
}
