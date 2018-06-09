package com.francescoxx.springboot.step;

import com.francescoxx.springboot.daytrip.Daytrip;
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

    //GET-ALL. Show steps of daytrip of the jwtUser
    @GetMapping
    public List<Step> getAllSteps(@PathVariable int jwtuserId, @PathVariable int daytripId) {
        return stepService.getAll(daytripId);
    }

    //GET-ONE
    @GetMapping("/{stepId}")
    public Step getOneStep(@PathVariable int stepId) {
        return stepService.get(stepId);
    }

    //CREATE-ONE
    @PostMapping
    public void addStepToDaytrip(@PathVariable int jwtuserId, @PathVariable int daytripId, @RequestBody Step step) {
        step.setDaytrip(new Daytrip(daytripId));
        stepService.add(step);
    }

    //UPDATE-ONE
    @PutMapping("/{stepId}")
    public void updateStep(
            @PathVariable int jwtuserId,
            @PathVariable int daytripId,
            @PathVariable int stepId,
            @RequestBody Step step) {

        step.setDaytrip(new Daytrip(daytripId));
        //More controls...
        stepService.update(jwtuserId, daytripId, stepId, step);
    }

    //DELETE-ONE
    @DeleteMapping("/{stepId}")
    public void deleteStep(@PathVariable int jwtuserId, @PathVariable int daytripId, @PathVariable int stepId) {
        stepService.delete(stepId);
    }
    //Custom Methods
}