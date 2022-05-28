package com.example.demo.demo.controllers;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.demo.EventService;
import com.example.demo.demo.GameService;
import com.example.demo.demo.PlayerService;
import com.example.demo.demo.TeamService;
import com.example.demo.demo.UserService;
import com.example.demo.entities.Player;
import com.example.demo.entities.Team;

@Controller
public class controllerPlayer {

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

    @GetMapping("/players")
    public String listPlayers(Model model) {
        List <Player> listPlayers = playerService.getAllPlayers();
        model.addAttribute("listPlayers", listPlayers);
        return "players_list";
    }

    @GetMapping("/registerPlayer")
    public String registrationPlayerForm(Model model){
        List <Team> listTeams = teamService.getAllTeams();
        model.addAttribute("player", new Player());
        model.addAttribute("listTeams", listTeams);
        return "new_player_form";
    }

    @PostMapping("/process_new_player")
    public String processRegister(Player player){
        playerService.addPlayer(player);
        return "redirect:/players";   
    }

}