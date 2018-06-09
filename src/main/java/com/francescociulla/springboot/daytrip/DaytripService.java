package com.francescociulla.springboot.daytrip;

import com.francescociulla.springboot.jwtuser.JwtUser;
import com.francescociulla.springboot.jwtuser.JwtUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/*
    Daytrip Service
 */
@Service
public class DaytripService {

    private final DaytripRepository daytripRepository;
    private JwtUserService jwtUserService;

    @Autowired
    public DaytripService(DaytripRepository daytripRepository, JwtUserService jwtUserService) {
        this.daytripRepository = daytripRepository;
        this.jwtUserService = jwtUserService;
    }

    //GET-ALL
    List<Daytrip> getAllDaytrips(int id) {
        List<Daytrip> daytrips = new ArrayList<>();
        daytrips.addAll(daytripRepository.findByJwtUserId(id)); //MAGIC! not implemented method!
        return daytrips;
    }

    //GET-ONE (GET)
    Daytrip getDaytrip(int jwtuserId, int id) {
        Daytrip toReturn = daytripRepository.findOne((id));

        if (toReturn.getJwtUser().getId() == jwtuserId) {
            return toReturn;
        } else {
            return null;
        }
    }

    //CREATE-ONE (POST)
    void addDaytrip(int jwtuserId, Daytrip daytrip) {
        daytripRepository.save(daytrip); //saves to a DB
    }

    //UPDATE-ONE (PUT)
    void updateDaytrip(int jwtuserId, int daytripId, Daytrip daytrip) {
        daytripRepository.save(daytrip); //save can do both create or updateDaytrip
    }

    //DELETE-ONE Daytrip
    void deleteDaytrip(int jwtuserId, int daytripId) {
        daytripRepository.delete(daytripId);
    }

    //Custom Methods
    Daytrip getDaytripByName(int jwtuserId, String name) {
        Daytrip toReturn = daytripRepository.findByName((name));

        if (toReturn.getJwtUser().getId() == jwtuserId) {
            return toReturn;
        } else {
            return null;
        }
    }
}
