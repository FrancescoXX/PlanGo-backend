package com.francescoxx.springboot.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
    Example of a Controller which needs JWT Authorization

    RestController:
    Mapping: /rest/hello
    Methods:
        - GET: getDaytrip a string message
        - Other methods here...
 */
@RestController
@RequestMapping("/rest/hello") // <-- accessing this url needs Token Authorization
public class HelloController {

    @GetMapping //Maps GET request at http://localhost:8084/rest/hello with GET METHOD
    public String hello(){

        return "Hello secret world with JWT!";
    }

    //PostMapping...
}