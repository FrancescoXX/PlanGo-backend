package com.francescociulla.springboot.security;

import com.francescociulla.springboot.model.JwtAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthenticationTokenFilter extends AbstractAuthenticationProcessingFilter {

    public JwtAuthenticationTokenFilter() {

        super("/secret/**"); // filter the secret area /rest/**
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {

        //Check for header "Authorisation" in request
        String header = httpServletRequest.getHeader("Authorization");
        if (header == null){
            throw new RuntimeException("No 'Authorization' Header");
        }

        if(!header.startsWith("Token ")) {
            throw new RuntimeException("Authorization header doesn't start with 'Token 123...' ");
        }

        //Assign authenticationToken to an object to authenticate it
        JwtAuthenticationToken token = new JwtAuthenticationToken(header.substring(6));//Remove 'Token ' from value in "Authorization" key Header

        //AUTHENTICATE TOKEN USING THIS PARTICULAR REQUEST
        return getAuthenticationManager().authenticate(token);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);
        chain.doFilter(request, response);
    }
}
