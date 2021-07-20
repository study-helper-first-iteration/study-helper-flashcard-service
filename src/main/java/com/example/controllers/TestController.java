package com.example.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    // create a route handler for /GET that simply returns "hello"
    @ResponseBody
    @GetMapping("/")
    public String test() {
        return "hello";
    }

}
