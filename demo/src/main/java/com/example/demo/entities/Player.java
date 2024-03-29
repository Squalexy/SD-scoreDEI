package com.example.demo.entities;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Player {

    @Id @GeneratedValue(strategy = GenerationType.AUTO) 
    private int id;

    private int nGoals;
    private int nYellow;
    private int nRed;
    private String name;
    private String position;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;

    @ManyToOne(cascade = CascadeType.ALL)
    private Team team;

    @OneToMany(mappedBy = "player")
    private List<Event> events;

    public Player(){}

    public Player(String name, String position, Date birthDate){
        this.name = name;
        this.position = position;
        this.birthDate = birthDate;
        this.nGoals = 0;
        this.events = new ArrayList<>();
    }

    public void addEvent(Event event){

        this.events.add(event);

        if (event.getName() == "b") this.nGoals += 1;
        else if (event.getName() == "c") this.nYellow += 1;
        else if (event.getName() == "d") this.nRed += 1;

    }

    public void addGoal(){
        this.nGoals ++;
    }

    public void addYellow(){
        this.nYellow ++;
    }

    public void addRed(){
        this.nRed ++;
    }

}
