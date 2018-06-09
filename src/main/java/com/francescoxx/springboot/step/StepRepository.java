package com.francescoxx.springboot.step;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/*
    StepRepository
    -custom query method: find a step by the id of his daytrip
 */

public interface StepRepository extends CrudRepository<Step, Integer > {
    List<Step> findByDaytripId(int daytripId);
}
