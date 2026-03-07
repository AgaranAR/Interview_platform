package com.agaran.Interview_platform.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping
    public String securedEndpoint(){
        return "JWT authentication working!";
    }
}
