package com.francescoxx.springboot.poi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/*
    @Service template
 */
@Service
public class PoiService {

    private final PoiRepository poiRepository;

    @Autowired
    public PoiService(PoiRepository poiRepository) {
        this.poiRepository = poiRepository;
    }

    //GET-ALL
    List<Poi> getAllPois() {
        List<Poi> steps = new ArrayList<>();
        poiRepository.findAll().forEach(steps::add);
        return steps;
    }

    //GET-ONE
    Poi getPoi(int id) {
        return poiRepository.findOne(id);
    }

    //CREATE-ONE
    void addPoi(Poi poi) {
        poiRepository.save(poi);
    }

    //UPDATE-ONE (PUT)
    void updatePoi(Poi poi) {
        poiRepository.save(poi);
    }

    //DELETE-ONE COURSE
    void deletePoi(int id) {
        poiRepository.delete(id);
    }

    //CUSTOM METHODS
}
