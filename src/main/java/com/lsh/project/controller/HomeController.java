package com.lsh.project.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {


    @GetMapping("/index")
    public String goIndex(){
        return "index5325";
    }

}
