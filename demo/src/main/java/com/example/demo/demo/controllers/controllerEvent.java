package com.example.demo.demo.controllers;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.demo.EventService;
import com.example.demo.demo.GameService;
import com.example.demo.demo.PlayerService;
import com.example.demo.demo.TeamService;
import com.example.demo.demo.UserService;
import com.example.demo.entities.Game;

@Controller
public class controllerEvent {

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

    @GetMapping("/games/events")
    public String viewEevents(@RequestParam(name="id", required=true) int id, Model m){
        Optional <Game> ga = this.gameService.getGame(id);
        if (ga.isPresent()){
            m.addAttribute("events", ga.get().getAllEvents());
            m.addAttribute("id", id);
            return "events_list";
        }
        return "redirect:/games_list";
    }
}