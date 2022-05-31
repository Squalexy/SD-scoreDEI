package com.example.demo.demo.controllers;

import com.example.demo.demo.EventService;
import com.example.demo.demo.GameService;
import com.example.demo.demo.PlayerService;
import com.example.demo.demo.TeamService;
import com.example.demo.entities.Event;
import com.example.demo.entities.Game;
import com.example.demo.entities.Player;
import com.example.demo.entities.Team;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.io.IOException;

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
    public String createFromREST() throws IOException, ParseException{
        ArrayList<Team> teams = new ArrayList<Team>();
        ArrayList<Integer> teamsID = new ArrayList<Integer>(); 
        ArrayList<Player> players = new ArrayList<Player>();

        HttpResponse<JsonNode> response =
        Unirest.get("https://v3.football.api-sports.io/teams")
        .queryString("league", 94)
        .queryString("season", 2021)
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
        
        for (int i = 0; i < teams.size(); i++){
            int id = teamsID.get(i);
            Team curTeam = teams.get(i);

            response = Unirest.get("https://v3.football.api-sports.io/players")
            .queryString("season", 2021)
            .queryString("team", id)
            .header("x-rapidapi-host", "v3.football.api-sports.io")
            .header("x-rapidapi-key", apiKey)
            .asJson();

            obj = JsonParser.parseString(response.getBody().toString()).getAsJsonObject();
            arr = obj.getAsJsonArray("response");

            for (int j = 0; j < arr.size(); j++){
                JsonObject player = arr.get(j).getAsJsonObject().get("player").getAsJsonObject();
                JsonObject stats = arr.get(j).getAsJsonObject().getAsJsonArray("statistics").get(0).getAsJsonObject();

                String playerName = player.get("name").getAsString();
                String birthStr = player.get("birth").getAsJsonObject().get("date").toString().replace("\"", "");
                System.out.println(playerName + " from " + curTeam.getName()+ "(" + Integer.toString(id) + ")" + " was born in " + birthStr);
                Date birthdate = new SimpleDateFormat("yyyy-MM-dd").parse(birthStr);
                String position = stats.get("games").getAsJsonObject().get("position").getAsString();

                Player p = new Player(playerName, position, birthdate);
                curTeam.addPlayer(p);
                players.add(p);
            }
        }

        for (Team t : teams){
            teamService.addTeam(t);
        }

        for (Player p : players){
            playerService.addPlayer(p);
        }

        return "redirect:/index";
    }
    
}
