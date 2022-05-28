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
        return "list_games";
    }

    @GetMapping("/registerGame")
    public String registrationGameForm(Model model){
        List <Team> listTeams = teamService.getAllTeams();
        model.addAttribute("game", new Game());
        model.addAttribute("listTeams", listTeams);
        return "form_game";
    }

    @PostMapping("/process_new_game")
    public String processRegister(Game game){
        gameService.addGame(game);
        return "redirect:/games";   
    }

    @GetMapping("/games/edit/{id}")
    public String editUser(@PathVariable("id") Integer id, Model model) {
        List <Team> listTeams = teamService.getAllTeams();
        Game game = gameService.get(id);
        model.addAttribute("game", game);
        model.addAttribute("listTeams", listTeams);
        return "form_game";
    }

}