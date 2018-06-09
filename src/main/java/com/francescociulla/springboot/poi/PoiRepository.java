package com.francescociulla.springboot.poi;

import org.springframework.data.repository.CrudRepository;

/*
    Repository model (CrudRepository)
    Set <Class, Primary Key>
 */
public interface PoiRepository extends CrudRepository<Poi, Integer> {
}
