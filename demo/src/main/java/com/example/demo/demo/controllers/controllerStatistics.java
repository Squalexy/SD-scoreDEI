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
import com.example.demo.entities.Player;

@Controller
public class controllerStatistics {

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

    @GetMapping("/statistics")
    public String listTeamsOrdered(Model model) {

        List<Team> listTeams = teamService.getAllTeams();
        List<Player> listPlayers = playerService.getBestPlayers();

        ArrayList<Integer> victories = new ArrayList<Integer>();
        ArrayList<Integer> defeats = new ArrayList<Integer>();
        ArrayList<Integer> same = new ArrayList<Integer>();
        ArrayList<Integer> games = new ArrayList<Integer>();

        for (Team t : listTeams) {
            victories.add(t.countVictories());
            defeats.add(t.countDefeats());
            same.add(t.countSame());
            games.add(t.countGames());
        }


        model.addAttribute("listTeams", listTeams);
        model.addAttribute("listPlayers", listPlayers);
        model.addAttribute("victories", victories);
        model.addAttribute("defeats", defeats);
        model.addAttribute("same", same);
        model.addAttribute("games", games);

        return "list_statistics";

    }
}