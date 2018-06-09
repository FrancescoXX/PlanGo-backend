package com.francescoxx.springboot.jwtuser;

import org.hibernate.MappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
    Jwtuser @RestController
 */

@RequestMapping("/users/jwtusers") //"users" will become "secured"
@RestController
public class JwtUserController {

    private static final String RESOURCE_ID = "/{jwtuserId}"; //not a Resource field: is the id to use in http mapping
    private final JwtUserService jwtUserService;

    @Autowired
    public JwtUserController(JwtUserService jwtUserService) { this.jwtUserService = jwtUserService;}

    @GetMapping
    public List<JwtUser> getAllJwtUsers() {
        return jwtUserService.getAllJwtUsers();
    }

    @GetMapping(RESOURCE_ID)
    public JwtUser getJwtUser(@PathVariable int jwtuserId) {
        return jwtUserService.getJwtUser(jwtuserId);
    }

    @PostMapping
    public void addJwtUser(@RequestBody JwtUser jwtUser) {
        if (jwtUser.getId() == 0) {
            jwtUserService.addJwtUser(jwtUser);
        } else {
            throw new MappingException("Error in mapping POST");
        }
    }

    @PutMapping(RESOURCE_ID)
    public void updateJwtUser(@PathVariable int jwtUserId, @RequestBody JwtUser jwtUser){
        if (jwtUser.getId() != 0) {
            jwtUserService.updateJwtUser(jwtUserId, jwtUser);
        } else {
            throw new MappingException("Error in mapping PUT");
        }
    }

    @DeleteMapping(RESOURCE_ID)
    public void deleteJwtUser(@PathVariable int jwtUserId) {
        jwtUserService.deleteJwtUser(jwtUserId);
    }

    //CUSTOM METHODS
    //GET-ONE by userName.
    //Returns a JwtUser
    @GetMapping("/byName/{jwtUserName}")
    public JwtUser getJwtUserByName(@PathVariable String jwtUserName) {
        return jwtUserService.getJwtUserByName(jwtUserName);
    }
}