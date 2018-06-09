package com.francescoxx.springboot.security;

import com.francescoxx.springboot.jwtuser.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

/*
    Jwt Json Validator: Contains a validate method to VALIDATE the Body of model JwtUser
 */
@Component
public class JwtValidator {

    private String secret = "youtube";

    public JwtUser validate(String token) {

        JwtUser jwtUser = null;
        try {
            Claims body = Jwts.parser() //we will parse the jwt message
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody(); //Payload

            //body is the JwtUser POJO model
            System.out.println("Body is:" + body);

            jwtUser = new JwtUser(body.getSubject(),(String) body.get("pass"),(String) body.get("role"));
            /*
            jwtUser.setUserName();
            jwtUser.setPassword(); //will return a String
            jwtUser.setRole();//finally we need the role
            */
            System.out.println("JwtUser is " + jwtUser);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return jwtUser;
    }
}
