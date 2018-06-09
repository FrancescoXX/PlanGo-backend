package com.francescociulla.springboot.model;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

//Not a direct model, extends a Spring Security class
public class JwtAuthenticationToken extends UsernamePasswordAuthenticationToken {

    //TOKEN
    private String token;

    public JwtAuthenticationToken(String token) {
        super(null, null); //no needed
        this.token = token;
    }

    //Returns nothing
    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }

    public String getToken() {
        return token;
    }
}
