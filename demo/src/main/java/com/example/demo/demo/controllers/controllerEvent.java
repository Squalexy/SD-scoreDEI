package com.example.demo.demo.controllers;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.demo.EventService;
import com.example.demo.demo.GameService;
import com.example.demo.demo.PlayerService;
import com.example.demo.demo.TeamService;
import com.example.demo.demo.UserService;
import com.example.demo.entities.Game;
import com.example.demo.entities.Event;
import com.example.demo.entities.Player;

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
            return "list_events";
        }
        return "redirect:/games";
    }

    @GetMapping("/games/addEvent/{id}")
    public String editUser(@PathVariable("id") Integer id, Model model) {
        Game game = gameService.get(id);
        Event event = new Event();
        event.setGame(game);
        List <Player> listPlayers = playerService.getAllPlayers();
        model.addAttribute("listPlayers", listPlayers);
        model.addAttribute("event", event);
        model.addAttribute("game", game);
        return "form_event";
    }

    @PostMapping("/process_new_event")
    public String processEvent(Event event){

        if (event.getName().equals("b")) {
            event.getPlayer().addGoal();
            if (event.getPlayer().getTeam().getName() == event.getGame().getTeams().get(0).getName()){
                event.getGame().setScoreA(event.getGame().getScoreA() + 1);
            }
            else if (event.getPlayer().getTeam().getName() == event.getGame().getTeams().get(1).getName()){
                event.getGame().setScoreB(event.getGame().getScoreB() + 1);
            }
        }

        else if (event.getName().equals("c")) event.getPlayer().addYellow();
        else if (event.getName().equals("d")) event.getPlayer().addRed();
        else if (event.getName().equals("e")) event.getGame().setState("paused");
        else if (event.getName().equals("f")) event.getGame().setState("resumed");
        event.setTheDescription();

        eventService.addEvent(event);

        return "redirect:/games";   
    }
}