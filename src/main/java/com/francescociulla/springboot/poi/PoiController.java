package com.francescociulla.springboot.poi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
    Restcontroller template: some fieds and the 5 basic CRUD operations
 */
@RequestMapping("/pois") //change with another resource
@RestController
public class PoiController {

    private static final String BASE_ID = "/{id}"; //base resource id
    private final PoiService poiService;

    @Autowired
    public PoiController(PoiService poiService) {
        this.poiService = poiService;
    }

    //GET-ALL
    @GetMapping()
    public List<Poi> getAll() {
        return poiService.getAllPois();
    }

    //Should not be exposed!

    //GET-ONE
    @GetMapping(BASE_ID)
    public Poi get(@PathVariable int id) {
        return poiService.getPoi(id);
    }

    //POST-ONE
    @PostMapping()
    public void add(@RequestBody Poi poi) {
        poiService.addPoi(poi);
    }

    //UPDATE-ONE
    @PutMapping(BASE_ID)
    public void update(@PathVariable int id, @RequestBody Poi poi) {
        poiService.updatePoi(poi);
    }

    //DELETE-ONE
    @DeleteMapping(BASE_ID)
    public void del(@PathVariable int id) {
        poiService.deletePoi(id);
    }
}