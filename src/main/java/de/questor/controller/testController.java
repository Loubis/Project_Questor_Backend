package de.questor.controller;

import de.questor.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class testController {

    @Autowired
    private TestService testService;

    @RequestMapping(value = "/test")
    @ResponseBody
    private String test() {
        testService.test();
        return "OK";
    }

}
