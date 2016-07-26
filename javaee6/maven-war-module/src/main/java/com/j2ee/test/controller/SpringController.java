package com.j2ee.test.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SpringController {
    
    private static final Logger logger = Logger.getLogger(SpringController.class);
    
    @RequestMapping(value="/helloWorld.web",method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {

        logger.info("Log4j info is working");
        logger.warn("Log4j warn is working");       
        logger.debug("Log4j debug is working");
        logger.error("Log4j error is working");
        System.out.println("System out is working");
        
        model.addAttribute("message", "Integration");
        return "helloWorld";

    }
}
