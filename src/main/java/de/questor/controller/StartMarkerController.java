package de.questor.controller;

import de.questor.model.StartMarker;
import de.questor.services.StartMarkerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/startMarkers")
public class StartMarkerController {

    private final StartMarkerService startMarkerService;

    public StartMarkerController(StartMarkerService startMarkerService) {
        this.startMarkerService = startMarkerService;
    }

    @GetMapping(
            path = "/{id}",
            produces = "application/json")
    @ResponseBody
    private StartMarker getById(@PathVariable("id") Integer id) {
        return startMarkerService.getById(id);
    }

    @GetMapping
    @ResponseBody
    private Iterable<StartMarker> getAll() {
        return startMarkerService.getAll();
    }

    @PostMapping(
            consumes = "application/json",
            produces = "application/json")
    @ResponseBody
    private StartMarker create(@RequestBody StartMarker startMarker) {
        return startMarkerService.create(startMarker);
    }

    @PostMapping(
            path = "/multiple",
            consumes = "application/json",
            produces = "application/json")
    @ResponseBody
    private Iterable<StartMarker> createMultiple(@RequestBody Iterable<StartMarker> startMarkers) {
        for (StartMarker sm : startMarkers)
            startMarkerService.create(sm);
        return startMarkers;
    }

    @PutMapping(
            consumes = "application/json",
            produces = "application/json")
    @ResponseBody
    private StartMarker update(@RequestBody StartMarker startMarker) {
        return startMarkerService.update(startMarker);
    }

    @DeleteMapping(path = "/{id}")
    private ResponseEntity delete(@PathVariable("id") Integer id) {
        startMarkerService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
