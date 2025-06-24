package com.entity;

import com.entity.TokenEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.Collections;

public class CustomUserDetails implements UserDetails {

    private final TokenEntity tokenEntity;

    public CustomUserDetails(TokenEntity tokenEntity) {
        this.tokenEntity = tokenEntity;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // 角色必须带前缀ROLE_
        if(tokenEntity.getRole() != null){
            return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + tokenEntity.getRole()));
        }
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return null; // token方式不需要密码
    }

    @Override
    public String getUsername() {
        return tokenEntity.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() { return true; }

    @Override
    public boolean isAccountNonLocked() { return true; }

    @Override
    public boolean isCredentialsNonExpired() { return true; }

    @Override
    public boolean isEnabled() { return true; }

    public TokenEntity getTokenEntity() { return tokenEntity; }
}
