package com.francescociulla.springboot.jwtuser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JwtUserService {

    private final JwtUserRepository jwtUserRepository;

    @Autowired
    public JwtUserService(JwtUserRepository jwtUserRepository) {
        this.jwtUserRepository = jwtUserRepository;
    }

    //GET-ALL JwtUsers
    List<JwtUser> getAllJwtUsers() {
        List<JwtUser> jwtUsers = new ArrayList<>();
        jwtUsers.addAll(jwtUserRepository.findAll());
        return jwtUsers;
    }

    //GET JwtUser
    public JwtUser getJwtUser(int jwtuserId) {
        return jwtUserRepository.findOne(jwtuserId);
    }

    //CREATE JwtUser (POST)
    void addJwtUser(JwtUser jwtUser) {
        jwtUserRepository.save(jwtUser);
    }

    //UPDATE JwtUser (PUT)
    void updateJwtUser( int jwtuserId, JwtUser jwtUser) {
        jwtUserRepository.save(jwtUser); //save can do both create or updateDaytrip
    }

    //DELETE JwtUser
    void deleteJwtUser(int jwtuserId) {
        jwtUserRepository.delete(jwtuserId);
    }

    //CUSTOM METHODS
    //Get by name
    public JwtUser getJwtUserByName(String name){
        return jwtUserRepository.findByUserName(name);
    }
}