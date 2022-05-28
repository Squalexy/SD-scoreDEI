package com.example.demo.repositories;

import com.example.demo.entities.Event;

import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Integer> {

}    
