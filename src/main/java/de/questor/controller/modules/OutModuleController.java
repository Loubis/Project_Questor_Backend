package de.questor.controller.modules;

import de.questor.model.modules.OutModule;
import de.questor.services.modules.OutModuleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/outModules")
public class OutModuleController {

    private final OutModuleService outModuleService;

    public OutModuleController(OutModuleService outModuleService) {
        this.outModuleService = outModuleService;
    }

    @GetMapping(
            path = "/{id}",
            produces = "application/json")
    @ResponseBody
    private OutModule getById(@PathVariable("id") Integer id) {
        return outModuleService.getById(id);
    }

    @GetMapping
    @ResponseBody
    private Iterable<OutModule> getAll() {
        return outModuleService.getAll();
    }

    @PostMapping(
            consumes = "application/json",
            produces = "application/json")
    @ResponseBody
    private ResponseEntity<OutModule> create(@RequestBody OutModule outModule) {
        if (outModule.getId() != null)
            return ResponseEntity.status(400).build();
        return ResponseEntity.status(201).body(outModuleService.create(outModule));
    }

    @PostMapping(
            path = "/multiple",
            consumes = "application/json",
            produces = "application/json")
    @ResponseBody
    private ResponseEntity<Iterable<OutModule>> createMultiple(@RequestBody Iterable<OutModule> outModules) {
        for (OutModule sm : outModules)
            if (sm.getId() != null)
                return ResponseEntity.status(400).build();
        for (OutModule sm : outModules)
            outModuleService.create(sm);
        return ResponseEntity.status(201).body(outModules);
    }

    @PutMapping(
            consumes = "application/json",
            produces = "application/json")
    @ResponseBody
    private ResponseEntity<OutModule> update(@RequestBody OutModule outModule) {
        if (outModule.getId() == null || outModuleService.getById(outModule.getId()) == null)
            return ResponseEntity.status(201).body(outModuleService.update(outModule));
        return ResponseEntity.ok(outModuleService.update(outModule));
    }

    @DeleteMapping(path = "/{id}")
    private ResponseEntity delete(@PathVariable("id") Integer id) {
        if (outModuleService.delete(id))
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}

