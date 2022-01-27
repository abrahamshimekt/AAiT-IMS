package com.codewithabe.AAiT.controllers;

import com.codewithabe.AAiT.models.Event;
import com.codewithabe.AAiT.repository.EventCatagoryRepository;
import com.codewithabe.AAiT.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value="/home")
public class EventCatagoryController {

    @Autowired
    EventRepository eventRepository;


    @Autowired
    private EventCatagoryRepository catagoryRepository;



    @GetMapping("/recent")
    public String showMed(Model model){
        List<Event> eventList = new ArrayList<>();
        this.eventRepository.findAll().forEach(i ->eventList.add(i));

        List<Event> recentEvent= eventList.stream()
                .filter(event -> event.getCatagory().getName().equalsIgnoreCase("Recent"))
                .collect(Collectors.toList());
        model.addAttribute("recent", recentEvent);
        return "category/recent";
    }

    @GetMapping(path = "/notice")
    public String showEyecare(Model model)
    {
        List<Event> eventList = new ArrayList<>();
        this.eventRepository.findAll().forEach(i ->eventList.add(i));

        List<Event> notice = eventList.stream()
                .filter(event-> event.getCatagory().getName().equalsIgnoreCase("Notice"))
                .collect(Collectors.toList());
        model.addAttribute("notice",notice );
        return "category/notice";
    }

//    @GetMapping(path = "/diabets")
//    public String showDiabets(Model model)
//    {
//        List<Medicine> medicineList = new ArrayList<>();
//        this.medicineRepository.findAll().forEach(i ->medicineList.add(i));
//
//        List<Medicine> diabetesMed = medicineList.stream()
//                .filter(medicine -> medicine.getCatagory().getName().equalsIgnoreCase("diabetes"))
//                .collect(Collectors.toList());
//        model.addAttribute("diabetes", diabetesMed);
//        return "category/diabets";
//    }
//
//    @GetMapping(path = "/std")
//    public String showStd(Model model)
//    {
//        List<Medicine> medicineList = new ArrayList<>();
//        this.medicineRepository.findAll().forEach(i ->medicineList.add(i));
//
//        List<Medicine> stdMed = medicineList.stream()
//                .filter(medicine -> medicine.getCatagory().getName().equalsIgnoreCase("std"))
//                .collect(Collectors.toList());
//        model.addAttribute("std", stdMed);
//        return "category/std";
//    }

}
