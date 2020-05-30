package br.com.clouddog.ecossambiental.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/")
@SuppressWarnings("unused")
class HomeController {

    private static final Logger log = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String handle() {
        log.info("handle");
        return "hello world";
    }
}