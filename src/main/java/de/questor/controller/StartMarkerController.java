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
    private ResponseEntity<StartMarker> create(@RequestBody StartMarker startMarker) {
        if (startMarker.getId() != null)
            return ResponseEntity.status(400).build();
        return ResponseEntity.status(201).body(startMarkerService.create(startMarker));
    }

    @PostMapping(
            path = "/multiple",
            consumes = "application/json",
            produces = "application/json")
    @ResponseBody
    private ResponseEntity<Iterable<StartMarker>> createMultiple(@RequestBody Iterable<StartMarker> startMarkers) {
        for (StartMarker sm : startMarkers)
            if (sm.getId() != null)
                return ResponseEntity.status(400).build();
        for (StartMarker sm : startMarkers)
            startMarkerService.create(sm);
        return ResponseEntity.status(201).body(startMarkers);
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
