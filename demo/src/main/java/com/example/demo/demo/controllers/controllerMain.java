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
import com.example.demo.entities.Event;
import com.example.demo.entities.Game;
import com.example.demo.entities.Player;
import com.example.demo.entities.Team;

@Controller
public class controllerMain {

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

    @GetMapping("/")
    public String redirectIndex() {
        return "index";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/teams")
    public String listTeams(Model model) {
        List <Team> listTeams = teamService.getAllTeams();
        model.addAttribute("listTeams", listTeams);
        return "teams_list";
    }

    @GetMapping("/games")
    public String listGames(Model model) {
        List <Game> listGames = gameService.getAllGames();
        model.addAttribute("listGames", listGames);
        return "games_list";
    }

    @GetMapping("/players")
    public String listPlayers(Model model) {
        List <Player> listPlayers = playerService.getAllPlayers();
        model.addAttribute("listPlayers", listPlayers);
        return "players_list";
    }

    @GetMapping("/events")
    public String listEvents(Model model) {
        List <Event> listEvents = eventService.getAllEvents();
        model.addAttribute("listEvents", listEvents);
        return "events_list";
    }

}