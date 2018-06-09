package com.francescociulla.springboot.step;

import com.francescociulla.springboot.daytrip.Daytrip;
import com.francescociulla.springboot.jwtuser.JwtUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
    Step @RestController
 */
@RequestMapping("/users/jwtusers/{jwtuserId}/daytrips/{daytripId}/steps")
@RestController
public class StepController {

    private final StepService stepService;

    @Autowired
    public StepController(StepService stepService) {
        this.stepService = stepService;
    }

    //GET-ALL. mostra gli steps del daytrip dell'utente
    @GetMapping
    public List<Step> getAllSteps(@PathVariable int jwtuserId, @PathVariable int daytripId) {
        return stepService.getAll(daytripId);
    }

    @GetMapping("/{stepId}")
    public Step getOneStep(@PathVariable int stepId) {
        return stepService.get(stepId);
    }

    @PostMapping
    public void addStepToDaytrip(@PathVariable int jwtuserId, @PathVariable int daytripId, @RequestBody Step step) {
        step.setDaytrip(new Daytrip(daytripId));
        stepService.add(step);
    }
    /*
            @PutMapping("/{daytripId}")
    public void updateDaytrip(@PathVariable int jwtuserId, @PathVariable int daytripId, @RequestBody Daytrip daytrip) {
        if (daytrip.getId() != 0) {
            daytrip.setJwtUser(new JwtUser(jwtuserId)); //set topic based on topic Id
            daytripService.updateDaytrip(jwtuserId, daytripId, daytrip);
        } else {
            throw new MappingException("Error in mapping PUT");
        }
    }
     */


    @PutMapping("/{stepId}")
    public void updateStep(
            @PathVariable int jwtuserId,
            @PathVariable int daytripId,
            @PathVariable int stepId,
            @RequestBody Step step){

        step.setDaytrip(new Daytrip(daytripId));
        //More controls...
        stepService.update(jwtuserId, daytripId, stepId, step);
    }

    @DeleteMapping("/{stepId}")
    public void deleteStep(@PathVariable int jwtuserId, @PathVariable int daytripId, @PathVariable int stepId) {
        stepService.delete(stepId);
    }
    //Custom Methods
}