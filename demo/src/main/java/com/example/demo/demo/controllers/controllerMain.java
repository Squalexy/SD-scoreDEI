package com.example.demo.demo.controllers;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/games/events")
    public String viewEevents(@RequestParam(name="id", required=true) int id, Model m){
        Optional <Game> ga = this.gameService.getGame(id);
        if (ga.isPresent()){
            m.addAttribute("events", ga.get().getEvents());
            m.addAttribute("id", id);
            return "events_list";
        }
        return "redirect:/games_list";
    }
}