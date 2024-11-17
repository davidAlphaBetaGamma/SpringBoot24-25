package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {

    @RequestMapping(value="/", method=RequestMethod.GET)
    @ResponseBody
    public String getHelloWorld() {
        return "<h1>Hello World Spring Boot!</h1>";
    }


}
