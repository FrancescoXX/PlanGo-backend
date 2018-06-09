package com.francescoxx.springboot.test;

import com.francescoxx.springboot.jwtuser.JwtUser;
import com.francescoxx.springboot.model.Token;
import com.francescoxx.springboot.security.JwtGenerator;
import com.francescoxx.springboot.jwtuser.JwtUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/*
    //Make a Post request to this url to get token
    Token Generator
 */
@RestController
@RequestMapping("/token") // <- Accessible url to get the Token
public class TokenController {

    private final JwtGenerator jwtGenerator;
    private final JwtUserService jwtUserService;

    @Autowired
    public TokenController(JwtGenerator jwtGenerator, JwtUserService jwtUserService) {

        this.jwtGenerator = jwtGenerator;
        this.jwtUserService = jwtUserService;
    }

    //Making a POST request to "/token" with a JwtUser in the body, you will get your token as a string
    @PostMapping
    public Token generate(@RequestBody final JwtUser jwtUser) {

        JwtUser j = jwtUserService.getJwtUserByName(jwtUser.getUserName());

        if(j.getPassword().equals(jwtUser.getPassword())){
            String t = jwtGenerator.generate(jwtUser);
            return new Token(t);
        }
        return null;
    }
}
