package com.example.demo.demo.controllers;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.demo.EventService;
import com.example.demo.demo.GameService;
import com.example.demo.demo.PlayerService;
import com.example.demo.demo.TeamService;
import com.example.demo.demo.UserService;
import com.example.demo.entities.Game;
import com.example.demo.entities.Team;

@Controller
public class controllerGame {

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

    @GetMapping("/games")
    public String listGames(Model model) {
        List <Game> listGames = gameService.getAllGames();
        model.addAttribute("listGames", listGames);
        return "games_list";
    }

    @GetMapping("/registerGame")
    public String registrationGameForm(Model model){
        List <Team> listTeams = teamService.getAllTeams();
        model.addAttribute("game", new Game());
        model.addAttribute("listTeams", listTeams);
        return "new_game_form";
    }

}