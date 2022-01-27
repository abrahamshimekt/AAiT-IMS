package com.codewithabe.AAiT.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String showHome(){
        return "home";
    }
    @GetMapping("/")
    public String redirectHome(){
        return "home";
    }

    
}
