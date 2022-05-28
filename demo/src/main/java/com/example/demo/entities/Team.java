package com.example.demo.entities;

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

    @Column(unique = true)
    private String name;
    
    @OneToMany(mappedBy= "team", cascade = CascadeType.ALL)
    private List <Player> players;

    @ManyToMany(cascade = CascadeType.ALL)
    private List <Game> games;

    public Team(){}

    public Team(String name){
        this.name = name;
        this.players = new ArrayList<>();
        this.games = new ArrayList<>();
    }

    public void addPlayer(Player player){
        this.players.add(player);
    }

    public void addGame(Game game){
        this.games.add(game);
    }
}
