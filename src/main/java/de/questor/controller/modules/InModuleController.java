package de.questor.controller.modules;

import de.questor.model.modules.InModule;
import de.questor.services.modules.InModuleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/inModules")
public class InModuleController {

    private final InModuleService inModuleService;

    public InModuleController(InModuleService inModuleService) {
        this.inModuleService = inModuleService;
    }

    @GetMapping(
            path = "/{id}",
            produces = "application/json")
    @ResponseBody
    private InModule getById(@PathVariable("id") Integer id) {
        return inModuleService.getById(id);
    }

    @GetMapping
    @ResponseBody
    private Iterable<InModule> getAll() {
        return inModuleService.getAll();
    }

    @PostMapping(
            consumes = "application/json",
            produces = "application/json")
    @ResponseBody
    private ResponseEntity<InModule> create(@RequestBody InModule inModule) {
        if (inModule.getId() != null)
            return ResponseEntity.status(400).build();
        return ResponseEntity.status(201).body(inModuleService.create(inModule));
    }

    @PostMapping(
            path = "/multiple",
            consumes = "application/json",
            produces = "application/json")
    @ResponseBody
    private ResponseEntity<Iterable<InModule>> createMultiple(@RequestBody Iterable<InModule> inModules) {
        for (InModule sm : inModules)
            if (sm.getId() != null)
                return ResponseEntity.status(400).build();
        for (InModule sm : inModules)
            inModuleService.create(sm);
        return ResponseEntity.status(201).body(inModules);
    }

    @PutMapping(
            consumes = "application/json",
            produces = "application/json")
    @ResponseBody
    private ResponseEntity<InModule> update(@RequestBody InModule inModule) {
        if (inModule.getId() == null || inModuleService.getById(inModule.getId()) == null)
            return ResponseEntity.status(201).body(inModuleService.update(inModule));
        return ResponseEntity.ok(inModuleService.update(inModule));
    }

    @DeleteMapping(path = "/{id}")
    private ResponseEntity delete(@PathVariable("id") Integer id) {
        if (inModuleService.delete(id))
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}

