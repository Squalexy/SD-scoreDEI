package com.example.demo.repositories;

import java.util.List;

import com.example.demo.entities.Game;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<Game, Integer> {

    @Query("SELECT g FROM Game as g ORDER BY g.startDate ASC, g.startDateTime ASC")
    public List<Game> retriveGames();

}    
