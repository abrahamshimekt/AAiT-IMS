package com.codewithabe.AAiT.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class ContactController {

    @GetMapping("/contact")
    public String showMedicine() {
        return "contact";
    }
}
