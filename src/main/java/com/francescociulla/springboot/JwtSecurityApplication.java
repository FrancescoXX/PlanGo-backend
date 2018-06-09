package com.francescociulla.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
    Integrate JWT in spring boot security application
	Need Spring jwt dependency
 */
@SpringBootApplication
public class JwtSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(JwtSecurityApplication.class, args);
    }
}
