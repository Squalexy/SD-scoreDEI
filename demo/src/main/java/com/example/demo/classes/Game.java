package com.example.demo.classes;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    private int scoreA;
    private int scoreB;

    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private Date startDate;

    @ManyToMany(mappedBy="games")
    private List <Team> teams;

    @OneToMany(mappedBy = "game")
    private List <Event> events;

    public Game(){}

    public Game(String localization, Date startDate){
        this.localization = localization;
        this.startDate = startDate;
        this.events = new ArrayList<>();
        this.teams = new ArrayList<>();
    }

    public void addEvent(Event event){
        this.events.add(event);
    }

    public void addTeam(Team team){
        this.teams.add(team);
    }
}
