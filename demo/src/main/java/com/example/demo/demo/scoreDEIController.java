package com.example.demo.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import com.example.demo.classes.Event;
import com.example.demo.classes.Game;
import com.example.demo.classes.Player;
import com.example.demo.classes.Team;
import com.example.demo.classes.User;
import com.example.demo.classes.Role;
import com.example.demo.repositories.UserRepository;

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

    @GetMapping("/")
    public String redirectIndex() {
        return "index";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/register")
    public String registrationForm(Model model){
        model.addAttribute("user", new User());
        return "signup_form";
    }

    @PostMapping("/process_register")
    public String processRegister(User user){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userService.addUser(user);
        return "register_success";   
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/index";
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        List <User> listUsers = userService.getAllUsers();
        model.addAttribute("listUsers", listUsers);
        return "users_list";
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
        model.addAttribute("listPlayer", listPlayers);
        return "players_list";
    }

    @GetMapping("/events")
    public String listEvents(Model model) {
        List <Event> listEvents = eventService.getAllEvents();
        model.addAttribute("listEvents", listEvents);
        return "events_list";
    }
}