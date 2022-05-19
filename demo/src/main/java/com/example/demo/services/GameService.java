package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.demo.classes.Game;
import com.example.demo.repositories.GameRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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