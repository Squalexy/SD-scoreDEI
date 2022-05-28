package com.example.demo.demo.controllers;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.demo.EventService;
import com.example.demo.demo.GameService;
import com.example.demo.demo.PlayerService;
import com.example.demo.demo.TeamService;
import com.example.demo.demo.UserService;
import com.example.demo.entities.Team;

@Controller
public class controllerTeam {

    @Autowired
    EventService eventService;
    @Autowired
    GameService gameService;
    @Autowired
    PlayerService playerService;
    @Autowired
    TeamService teamService;
    @Autowired
    UserService userService;

    @GetMapping("/teams")
    public String listTeams(Model model) {
        List <Team> listTeams = teamService.getAllTeams();
        model.addAttribute("listTeams", listTeams);
        return "list_teams";
    }

    @GetMapping("/registerTeam")
    public String registrationTeamForm(Model model){
        model.addAttribute("team", new Team());
        return "form_team";
    }

    @GetMapping("/teams/edit/{id}")
    public String editTeam(@PathVariable("id") Integer id, Model model) {
        Team team = teamService.get(id);
        model.addAttribute("team", team);
        return "form_team";
    }

    @PostMapping("/process_new_team")
    public String processRegister(Team team){
        teamService.addTeam(team);
        return "redirect:/teams";   
    }

}