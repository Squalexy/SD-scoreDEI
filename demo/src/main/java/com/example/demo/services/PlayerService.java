package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.demo.classes.Player;
import com.example.demo.repositories.PlayerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service   
public class PlayerService {

    @Autowired    
    private PlayerRepository playerRepository;

    public List <Player> getAllPlayers(){
        List <Player> playerRecords = new ArrayList<>();
        playerRepository.findAll().forEach(playerRecords::add);
        return playerRecords;
    }

    public void addPlayer(Player player)  
    {    
        playerRepository.save(player);    
    }

    public Optional<Player> getPlayer(int id) {
        return playerRepository.findById(id);
    }
    
}