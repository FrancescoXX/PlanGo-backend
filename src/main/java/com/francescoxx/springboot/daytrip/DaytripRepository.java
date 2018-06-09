package com.francescoxx.springboot.daytrip;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DaytripRepository extends CrudRepository<Daytrip, Integer> {

    /*  FINDS ALL Daytrips FILTERED BY JwtUser id! AUTOMATICALLY!
        CHECK THE SYNTAX

        Look for JwtUser, which is a class,
        then  look for Id, which is a field fo that particular class
     */
    List<Daytrip> findByJwtUserId(int jwtUserId);

    /*
        With proper naming, can provide HINT for Spring data Jpa
        about what do you need to filter by (kinda crazy!)

        Because the CrudRepository already knows how to getDaytrip records
        we can getDaytrip all the record which match a particular condition
     */

    //CUSTOM FIND METHOD
    Daytrip findByName(String name);
}
