package com.example.demo.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.classes.Event;
import com.example.demo.classes.Game;
import com.example.demo.classes.Player;
import com.example.demo.classes.Team;
import com.example.demo.classes.User;

@Controller
public class scoreDEIController {

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

    @GetMapping("")
    public String viewIndex() {
        return "index";
    }

    @GetMapping("/")
    public String redirectIndex() {
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

}