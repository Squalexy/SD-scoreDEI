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

@Entity
public class Player {

    @Getter
    @Setter

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id, nGoals, nYellow, nRed;
    private String name, position;
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
 
    @Override public String toString(){
        String s = new SimpleDateFormat("dd/MM/yyyy HH:mm::ss").format(birthDate);
        return String.format("""
                            Player: %s%n
                            Position: %s%n
                            Birth date: %s%n
                            Total number of goals: %s%n
                            Total number of yellow cards: %s%n
                            Total number of red cards: %s%n
                            """, this.name, this.position, s, this.nGoals, this.nYellow, this.nRed);
    }

}
