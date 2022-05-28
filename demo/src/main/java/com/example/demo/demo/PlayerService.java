package com.example.demo.demo;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Player;
import com.example.demo.repositories.PlayerRepository;

@Service   
public class PlayerService {

    @Autowired    
    private PlayerRepository playerRepository;

    public List <Player> getAllPlayers(){
        List <Player> playerRecords = new ArrayList<>();
        playerRepository.retrievePlayers().forEach(playerRecords::add);
        return playerRecords;
    }

    public void addPlayer(Player player)  
    {    
        playerRepository.save(player);    
    }

    public Optional<Player> getPlayer(int id) {
        return playerRepository.findById(id);
    }
    
    public Player get(Integer id) {
        return playerRepository.findById(id).get();
    }
    
}