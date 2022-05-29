package com.example.demo.demo.controllers;

import java.util.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.demo.EventService;
import com.example.demo.demo.GameService;
import com.example.demo.demo.PlayerService;
import com.example.demo.demo.TeamService;
import com.example.demo.demo.UserService;
import com.example.demo.entities.Role;
import com.example.demo.entities.User;

@Controller
public class controllerUser {

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

    @GetMapping("/registerUser")
    public String registrationForm(Model model){
        model.addAttribute("user", new User());
        return "form_signup";
    }

    @PostMapping("/process_register")
    public String processRegister(@Valid User user, BindingResult bindingResult, Model model){
        
        if(userService.getEmail(user.getEmail()) == 1){
            bindingResult.rejectValue("email", "user.email","An account already exists for this email.");
            model.addAttribute("registrationForm", user);
            return "form_signup";
        }

        if(userService.getUsername(user.getUsername()) == 1){
            bindingResult.rejectValue("username", "user.username","An account already exists for this username.");
            model.addAttribute("registrationForm", user);
            return "form_signup";
        }

        if(userService.getTelephone(user.getTelephone()) == 1){
            bindingResult.rejectValue("telephone", "user.telephone","An account already exists with this telephone number.");
            model.addAttribute("registrationForm", user);
            return "form_signup";
        }

        if(bindingResult.hasErrors()){
            model.addAttribute("user", user);
            return "form_signup";
        }

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userService.registerDefaultUser(user);

        return "redirect:/users"; 

    }

    @PostMapping("/process_edit")
    public String processEdit(@Valid User user, BindingResult bindingResult, Model model){

        if(userService.getEmailEdit(user.getEmail(), user.getUsername()) == 1){
            bindingResult.rejectValue("email", "user.email","An account already exists for this email.");
            model.addAttribute("registrationForm", user);
            return "form_edit_user";
        }

        if(userService.getUsernameEdit(user.getUsername()) == 1){
            bindingResult.rejectValue("username", "user.username","An account already exists for this username.");
            model.addAttribute("registrationForm", user);
            return "form_edit_user";
        }

        if(userService.getTelephoneEdit(user.getTelephone(), user.getUsername()) == 1){
            bindingResult.rejectValue("telephone", "user.telephone","An account already exists with this telephone number.");
            model.addAttribute("registrationForm", user);
            return "form_edit_user";
        }

        if(bindingResult.hasErrors()){
            model.addAttribute("user", user);
            return "form_edit_user";
        }
        
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userService.registerDefaultUser(user);

        return "redirect:/users"; 

    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/index";
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        List <User> listUsers = userService.getAllUsers();
        model.addAttribute("listUsers", listUsers);
        return "list_users";
    }

    @GetMapping("/users/edit/{id}")
    public String editUser(@PathVariable("id") Integer id, Model model) {
        User user = userService.get(id);
        List<Role> listRoles = userService.listRoles();
        model.addAttribute("user", user);
        model.addAttribute("listRoles", listRoles);
        return "form_edit_user";
    }

    @PostMapping("/users/save")
    public String saveUser(User user) {
        userService.addUser(user);
        return "redirect:/users";
    }



}