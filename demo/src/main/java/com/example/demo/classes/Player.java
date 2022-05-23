package com.example.demo.classes;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
    private Date birthDate;

    @OneToMany(mappedBy="players")
    private Team team;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Event> events;

    public Player(){}

    public Player(String name, String position, Date birthDate){
        this.name = name;
        this.position = position;
        this.birthDate = birthDate;
        this.nGoals = 0;
    }

    public void addGoal(){
        this.nGoals += 1;
    }
}
