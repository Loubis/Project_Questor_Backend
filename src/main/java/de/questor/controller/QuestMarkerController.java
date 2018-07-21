package de.questor.controller;

import de.questor.model.QuestMarker;
import de.questor.services.QuestMarkerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/questMarkers")
public class QuestMarkerController {

    private final QuestMarkerService questMarkerService;

    public QuestMarkerController(QuestMarkerService questMarkerService) {
        this.questMarkerService = questMarkerService;
    }

    @GetMapping(
            path = "/{id}",
            produces = "application/json")
    @ResponseBody
    private QuestMarker getById(@PathVariable("id") Integer id) {
        return questMarkerService.getById(id);
    }

    @GetMapping
    @ResponseBody
    private Iterable<QuestMarker> getAll() {
        return questMarkerService.getAll();
    }

    @PostMapping(
            consumes = "application/json",
            produces = "application/json")
    @ResponseBody
    private ResponseEntity<QuestMarker> create(@RequestBody QuestMarker questMarker) {
        if (questMarker.getId() != null)
            return ResponseEntity.status(400).build();
        return ResponseEntity.status(201).body(questMarkerService.create(questMarker));
    }

    @PostMapping(
            path = "/multiple",
            consumes = "application/json",
            produces = "application/json")
    @ResponseBody
    private ResponseEntity<Iterable<QuestMarker>> createMultiple(@RequestBody Iterable<QuestMarker> questMarkers) {
        for (QuestMarker sm : questMarkers)
            if (sm.getId() != null)
                return ResponseEntity.status(400).build();
        for (QuestMarker sm : questMarkers)
            questMarkerService.create(sm);
        return ResponseEntity.status(201).body(questMarkers);
    }

    @PutMapping(
            consumes = "application/json",
            produces = "application/json")
    @ResponseBody
    private QuestMarker update(@RequestBody QuestMarker questMarker) {
        return questMarkerService.update(questMarker);
    }

    @DeleteMapping(path = "/{id}")
    private ResponseEntity delete(@PathVariable("id") Integer id) {
        questMarkerService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
