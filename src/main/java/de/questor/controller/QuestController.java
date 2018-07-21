package de.questor.controller;

import de.questor.model.Quest;
import de.questor.services.QuestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/quests")
public class QuestController {

    private final QuestService questService;

    public QuestController(QuestService questService) {
        this.questService = questService;
    }

    @GetMapping(
            path = "/{id}",
            produces = "application/json")
    @ResponseBody
    private Quest getById(@PathVariable("id") Integer id) {
        return questService.getById(id);
    }

    @GetMapping
    @ResponseBody
    private Iterable<Quest> getAll() {
        return questService.getAll();
    }

    @PostMapping(
            consumes = "application/json",
            produces = "application/json")
    @ResponseBody
    private ResponseEntity<Quest> create(@RequestBody Quest quest) {
        if (quest.getId() != null)
            return ResponseEntity.status(400).build();
        return ResponseEntity.status(201).body(questService.create(quest));
    }

    @PostMapping(
            path = "/multiple",
            consumes = "application/json",
            produces = "application/json")
    @ResponseBody
    private ResponseEntity<Iterable<Quest>> createMultiple(@RequestBody Iterable<Quest> quests) {
        for (Quest sm : quests)
            if (sm.getId() != null)
                return ResponseEntity.status(400).build();
        for (Quest sm : quests)
            questService.create(sm);
        return ResponseEntity.status(201).body(quests);
    }

    @PutMapping(
            consumes = "application/json",
            produces = "application/json")
    @ResponseBody
    private Quest update(@RequestBody Quest quest) {
        return questService.update(quest);
    }

    @DeleteMapping(path = "/{id}")
    private ResponseEntity delete(@PathVariable("id") Integer id) {
        questService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
