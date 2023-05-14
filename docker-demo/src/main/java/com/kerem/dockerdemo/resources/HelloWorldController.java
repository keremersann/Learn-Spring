package com.kerem.dockerdemo.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping("/")
    public String helloWorld(){
        return "{message: Hello World Java v1}";
    }
}
