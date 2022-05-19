package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.demo.classes.Team;
import com.example.demo.repositories.TeamRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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