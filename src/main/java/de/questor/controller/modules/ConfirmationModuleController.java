package de.questor.controller.modules;

import de.questor.model.modules.ConfirmationModule;
import de.questor.services.modules.ConfirmationModuleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/confirmationModules")
public class ConfirmationModuleController {

    private final ConfirmationModuleService confirmationModuleService;

    public ConfirmationModuleController(ConfirmationModuleService confirmationModuleService) {
        this.confirmationModuleService = confirmationModuleService;
    }

    @GetMapping(
            path = "/{id}",
            produces = "application/json")
    @ResponseBody
    private ConfirmationModule getById(@PathVariable("id") Integer id) {
        return confirmationModuleService.getById(id);
    }

    @GetMapping
    @ResponseBody
    private Iterable<ConfirmationModule> getAll() {
        return confirmationModuleService.getAll();
    }

    @PostMapping(
            consumes = "application/json",
            produces = "application/json")
    @ResponseBody
    private ResponseEntity<ConfirmationModule> create(@RequestBody ConfirmationModule confirmationModule) {
        if (confirmationModule.getId() != null)
            return ResponseEntity.status(400).build();
        return ResponseEntity.status(201).body(confirmationModuleService.create(confirmationModule));
    }

    @PostMapping(
            path = "/multiple",
            consumes = "application/json",
            produces = "application/json")
    @ResponseBody
    private ResponseEntity<Iterable<ConfirmationModule>> createMultiple(@RequestBody Iterable<ConfirmationModule> confirmationModules) {
        for (ConfirmationModule sm : confirmationModules)
            if (sm.getId() != null)
                return ResponseEntity.status(400).build();
        for (ConfirmationModule sm : confirmationModules)
            confirmationModuleService.create(sm);
        return ResponseEntity.status(201).body(confirmationModules);
    }

    @PutMapping(
            consumes = "application/json",
            produces = "application/json")
    @ResponseBody
    private ResponseEntity<ConfirmationModule> update(@RequestBody ConfirmationModule confirmationModule) {
        if (confirmationModule.getId() == null || confirmationModuleService.getById(confirmationModule.getId()) == null)
            return ResponseEntity.status(201).body(confirmationModuleService.update(confirmationModule));
        return ResponseEntity.ok(confirmationModuleService.update(confirmationModule));
    }

    @DeleteMapping(path = "/{id}")
    private ResponseEntity delete(@PathVariable("id") Integer id) {
        if (confirmationModuleService.delete(id))
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}

