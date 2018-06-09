package com.francescociulla.springboot.step;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/*
    Step Service
 */

@Service
public class StepService {

    private final StepRepository stepRepository;

    @Autowired
    public StepService(StepRepository stepRepository) {
        this.stepRepository = stepRepository;
    }

    //GET-ALL
    List<Step> getAll(int id) {
        List<Step> steps = new ArrayList<>();
        steps.addAll(stepRepository.findByDaytripId(id)); //MAGIC! not implemented method!
        System.out.println(steps);
        return steps;
    }

    //GET-ONE
    public Step get(int id) {
        return stepRepository.findOne(id);
    }

    //CREATE-ONE
    void add(Step step) {
        stepRepository.save(step);
    }

    //UPDATE-ONE (PUT)
    public void update(int jwtuserId, int daytripId, int stepId, Step step) {
        stepRepository.save(step);
    }

    //DELETE-ONE COURSE
    void delete(int id) {
        stepRepository.delete(id);
    }
}
