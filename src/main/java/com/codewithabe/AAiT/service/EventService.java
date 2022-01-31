package com.codewithabe.AAiT.service;


import com.codewithabe.AAiT.repository.EventCatagoryRepository;
import com.codewithabe.AAiT.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private EventCatagoryRepository catagoryRepository;


}


