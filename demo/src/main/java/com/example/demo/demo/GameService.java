package com.example.demo.demo;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Game;
import com.example.demo.repositories.GameRepository;

@Service   
public class GameService {

    @Autowired    
    private GameRepository gameRepository;

    public List <Game> getAllGames(){
        List <Game> gameRecords = new ArrayList<>();
        gameRepository.findAll().forEach(gameRecords::add);
        return gameRecords;
    }

    public void addGame(Game game)  
    {    
        gameRepository.save(game);    
    }

    public Optional<Game> getGame(int id) {
        return gameRepository.findById(id);
    }
    
}