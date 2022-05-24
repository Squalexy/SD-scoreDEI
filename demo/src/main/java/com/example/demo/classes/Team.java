package com.example.demo.classes;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Team {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name, imageLink;
    
    @OneToMany(cascade = CascadeType.ALL)
    private List <Player> players;

    @ManyToMany(cascade = CascadeType.ALL)
    private List <Game> games;

    public Team(){}

    public Team(String name, String imageLink){
        this.name = name;
        this.imageLink = imageLink;
        this.players = new ArrayList<>();
        this.games = new ArrayList<>();
    }
}
