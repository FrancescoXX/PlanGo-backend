package com.francescociulla.springboot.security;


import com.francescociulla.springboot.jwtuser.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
/*
       Jwt Token Generator. Token will be generated as a String with userName values
 */
@Component
public class JwtGenerator {

    private String mySecret = "youtube";

    /*  METHOD TO GENERATE A TOKEN WITH A JwtUser Parameter
        String return type is the TOKEN
     */
    public String generate(JwtUser jwtUser) {

        String tokenToReturn;

        //Create a Claims
        Claims claims = Jwts.claims();

        //Claims has the JwtUser username, the userId and the role
        claims.setSubject(jwtUser.getUserName());
        claims.put("pass", jwtUser.getPassword());
        claims.put("role", jwtUser.getRole());

        //String Token to Return
        tokenToReturn  = Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, mySecret)
                .compact();

        return tokenToReturn;
    }
}
