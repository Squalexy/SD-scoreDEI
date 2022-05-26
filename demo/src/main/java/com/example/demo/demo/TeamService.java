package com.example.demo.demo;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Team;
import com.example.demo.repositories.TeamRepository;

@Service   
public class TeamService {

    @Autowired    
    private TeamRepository teamRepository;

    public List <Team> getAllTeams(){
        List <Team> teamRecords = new ArrayList<>();
        teamRepository.findAll().forEach(teamRecords::add);
        return teamRecords;
    }

    public void addTeam(Team team)  
    {    
        teamRepository.save(team);    
    }

    public Optional<Team> getTeam(int id) {
        return teamRepository.findById(id);
    }
    
}