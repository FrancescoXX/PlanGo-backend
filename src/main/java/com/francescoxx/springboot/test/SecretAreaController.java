package com.francescoxx.springboot.test;

import com.francescoxx.springboot.jwtuser.JwtUserService;
import com.francescoxx.springboot.model.Secret;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secret")
public class SecretAreaController {

    private final JwtUserService jwtUserService;

    @Autowired
    public SecretAreaController(JwtUserService jwtUserService) {
        this.jwtUserService = jwtUserService;
    }

    @GetMapping
    public Secret secret() {

        return new Secret(1010);
    }

    //PostMapping...
}
