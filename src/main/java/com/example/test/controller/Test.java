package com.example.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/test")
@RestController
public class Test {


    @GetMapping("/api")
    public String test() {
        return "我是大帅批66666666666666666666666666666666666";
    }

}
