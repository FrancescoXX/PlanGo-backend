package com.francescociulla.springboot.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
    To Handle response codes
 */
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {

        //System.out.println("commence: " +getClass().getEnclosingMethod().toString());
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "UNAUTHORIZED");
        /*
        System.out.println("entry point");
        int status = response.getStatus();
        switch (status){

            //Not Authorized
            case HttpServletResponse.SC_UNAUTHORIZED: {//401 code
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "UNHAUTHORZIED");
            }
        }
        */
    }

}
