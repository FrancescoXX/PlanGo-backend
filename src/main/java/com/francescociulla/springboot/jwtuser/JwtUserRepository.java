package com.francescociulla.springboot.jwtuser;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JwtUserRepository extends JpaRepository<JwtUser, Integer> {

    JwtUser findByUserName(String username);

}
