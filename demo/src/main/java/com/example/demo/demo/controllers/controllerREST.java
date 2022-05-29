package com.example.demo.demo.controllers;

import com.example.demo.demo.EventService;
import com.example.demo.demo.GameService;
import com.example.demo.demo.PlayerService;
import com.example.demo.demo.TeamService;
import com.example.demo.entities.Event;
import com.example.demo.entities.Game;
import com.example.demo.entities.Player;
import com.example.demo.entities.Role;
import com.example.demo.entities.Team;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@Controller
public class controllerREST {
    @Autowired
    EventService eventService;
    @Autowired
    GameService gameService;
    @Autowired
    PlayerService playerService;
    @Autowired
    TeamService teamService;

    private String apiKey = "3ae8759502ecadb1a50fd386f98d154c";

    @PostMapping("/createFromREST")
    public String createFromREST() throws IOException{
        ArrayList<Team> teams = new ArrayList<Team>();
        ArrayList<Integer> teamsID = new ArrayList<Integer>(); 
        ArrayList<Player> players = new ArrayList<Player>();

        HttpResponse<JsonNode> response =
        Unirest.get("https://v3.football.api-sports.io/teams?league=94&season=2021")
        .header("x-rapidapi-host", "v3.football.api-sports.io")
        .header("x-rapidapi-key", apiKey)
        .asJson();

        JsonObject obj = JsonParser.parseString(response.getBody().toString()).getAsJsonObject();
        JsonArray arr = obj.getAsJsonArray("response");

        for (int i = 0; i < arr.size(); i++){
            JsonObject team = arr.get(i).getAsJsonObject().get("team").getAsJsonObject();
            
            String teamName = team.get("name").getAsString();
            int teamID = team.get("id").getAsInt();
            teams.add(new Team(teamName));
            teamsID.add(teamID);
        }
        
        for (Team t : teams){
            teamService.addTeam(t);
        }
        return "redirect:/index";
    }
    
}
