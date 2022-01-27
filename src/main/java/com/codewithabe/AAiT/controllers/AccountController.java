package com.codewithabe.AAiT.controllers;

import com.codewithabe.AAiT.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccountController {
    @GetMapping("/userdashboard")
    public String showUserDashBoard() {
        return "meds/userdashboard";
    }

    @Autowired
    private CourseRepository repository;

    @GetMapping({"/userdashboard/orders"})
    public ModelAndView getAllOrders() {
        ModelAndView mav = new ModelAndView("meds/userdashboard");
        mav.addObject("orders", repository.findAll());
        return mav;
    }
}