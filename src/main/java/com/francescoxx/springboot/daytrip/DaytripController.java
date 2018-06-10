package com.francescoxx.springboot.daytrip;

/*
    Daytrip @RestController
 */
import com.francescoxx.springboot.jwtuser.JwtUser;
import org.hibernate.MappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users/jwtusers/{jwtuserId}/daytrips")
@RestController
public class DaytripController {

    private final DaytripService daytripService;

    @Autowired
    public DaytripController(DaytripService daytripService) {
        this.daytripService = daytripService;
    }

    //GET-ALL Get All daytrips to a particular {jwtuserId}. Passed as @PathVariable
    // need to access to a path of a particular id
    @GetMapping
    public List<Daytrip> getAllDaytrips(@PathVariable int jwtuserId) {
        return daytripService.getAllDaytrips(jwtuserId);
    }

    @GetMapping("/{daytripId}")
    public Daytrip getDaytrip(@PathVariable int jwtuserId, @PathVariable int daytripId) {
        System.out.println("FOUND A daytrip to return" + daytripService.getDaytrip(jwtuserId, daytripId));
        return daytripService.getDaytrip(jwtuserId, daytripId);
    }

    @PostMapping
    public void addDaytrip(@PathVariable int jwtuserId, @RequestBody Daytrip daytrip) {
        if (daytrip.getId() == 0) {
            daytrip.setJwtUser(new JwtUser(jwtuserId)); //il daytrip si setta un Jwtuser che contiene solamente l'id
            daytripService.addDaytrip(jwtuserId, daytrip);
            System.out.println("Created daytrip: " + daytrip);
        } else {
            throw new MappingException("Error in mapping POST");
        }
    }

    @PutMapping("/{daytripId}")
    public void updateDaytrip(@PathVariable int jwtuserId, @PathVariable int daytripId, @RequestBody Daytrip daytrip) {
        if (daytrip.getId() != 0) {
            daytrip.setJwtUser(new JwtUser(jwtuserId)); //set topic based on topic Id
            daytripService.updateDaytrip(jwtuserId, daytripId, daytrip);
        } else {
            throw new MappingException("Error in mapping PUT");
        }
    }

    @DeleteMapping("/{daytripId}")
    public void deleteDaytrip(@PathVariable int jwtuserId, @PathVariable int daytripId) {
        daytripService.deleteDaytrip(jwtuserId, daytripId);
    }

    //CUSTOM METHODS
    //GET-ONE by userName.
    //Returns a Daytrip
    @GetMapping("/{daytripId}/byName/{name}")
    public Daytrip getDaytripByName(@PathVariable int jwtuserId, @PathVariable String name) {
        return daytripService.getDaytripByName(jwtuserId,name);
    }
}
