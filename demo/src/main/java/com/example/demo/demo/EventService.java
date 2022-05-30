package com.example.demo.demo;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Event;
import com.example.demo.repositories.EventRepository;

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

    public Event get(Integer id) {
        return eventRepository.findById(id).get();
    }
    
}