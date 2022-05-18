package com.example.demo.data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {

    @Getter
    @Setter

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name, imageLink;
    @OneToMany(cascade = CascadeType.ALL)
    private List <Player> players;

    public Team(){}

    public Team(String name, String imageLink){
        this.name = name;
        this.imageLink = imageLink;
        this.players = new ArrayList<>();
    }
 

    @Override public String toString(){
        String playersList = this.players.toString();
        return String.format("""
                            Team: %s%n
                            Players: %s%n
                            """, this.name, playersList);
    }

}
