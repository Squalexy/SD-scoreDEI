package com.example.demo.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Game {

    @Id @GeneratedValue(strategy = GenerationType.AUTO) 
    private int id;

    private String localization;
    private int scoreA = 0;
    private int scoreB = 0;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    private String startDateTime;

    @ManyToMany(cascade = CascadeType.ALL)
    private List <Team> teams;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
    private List <Event> events;

    private String state;

    public Game(){}

    public Game(String localization, Date startDate){
        this.localization = localization;
        this.startDate = startDate;
        this.events = new ArrayList<>();
        this.teams = new ArrayList<>();
    }

    public Game(String localization, Date startDate, String time, String state){
        this.localization = localization;
        this.startDate = startDate;
        this.startDateTime = time;
        this.state = state;
        this.events = new ArrayList<>();
        this.teams = new ArrayList<>();
    }

    public void addEvent(Event event){
        this.events.add(event);
    }

    public void addTeam(Team team){
        this.teams.add(team);
    }

    public String getGameName(){
        return "" + this.teams.get(0) + " vs " + this.teams.get(1);
    }


    public List<Event> getAllEvents(){
        Collections.sort(this.events, Comparator.comparing(Event::getStartEvent).thenComparing(Event::getStartEventTime));
        return this.events;
    }

    public String getState(){
        return this.state;
    }
}
