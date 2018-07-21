package de.questor.controller;

import de.questor.services.StartMarkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StartMarkerController {

    @Autowired
    private StartMarkerService startMarkerService;

    @RequestMapping(value = "/test")
    @ResponseBody
    private String test() {
        startMarkerService.test();
        return "OK";
    }

}
