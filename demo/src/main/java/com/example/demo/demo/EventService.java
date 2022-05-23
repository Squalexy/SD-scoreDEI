package com.example.demo.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.demo.classes.Event;
import com.example.demo.repositories.EventRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service   
public class EventService {

    @Autowired    
    private EventRepository eventRepository;

    public List <Event> getAllEvents(){
        List <Event> eventRecords = new ArrayList<>();
        eventRepository.findAll().forEach(eventRecords::add);
        return eventRecords;
    }

    public void addEvent(Event event)  
    {    
        eventRepository.save(event);    
    }

    public Optional<Event> getEvent(int id) {
        return eventRepository.findById(id);
    }
    
}