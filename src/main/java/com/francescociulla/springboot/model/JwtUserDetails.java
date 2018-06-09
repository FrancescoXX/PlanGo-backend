package com.francescociulla.springboot.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/*
    UserDetails Model

 */
public class JwtUserDetails implements UserDetails {

    private String userName;
    private String token;
    private String id;
    private Collection<? extends GrantedAuthority> authorities;

    public JwtUserDetails(String userName, String token, String id, Collection<? extends GrantedAuthority> grantedAuthorities) {
        this.userName = userName;
        this.token = token;
        this.id = id;
        this.authorities = grantedAuthorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return id;
    }

    @Override
    public String getUsername() {
        return userName;
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
        return true;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getToken() {
        return token;
    }
}
