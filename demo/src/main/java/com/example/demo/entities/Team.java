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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private List<Player> players;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Game> games;

    public Team() {
    }

    public Team(String name) {
        this.name = name;
        this.players = new ArrayList<>();
        this.games = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void addGame(Game game) {
        this.games.add(game);
    }

    public int countVictories() {
        int victories = 0;
        for (Game g : this.games) {
            if (g.getTeams().get(0).name == this.name && g.getScoreA() > g.getScoreB() && g.getState() == "finished") victories ++;
            else if (g.getTeams().get(1).name == this.name && g.getScoreB() > g.getScoreA() && g.getState() == "finished") victories ++;
        }
        return victories;
    }

    public int countDefeats() {
        int victories = 0;
        for (Game g : this.games) {
            if (g.getTeams().get(0).name == this.name && g.getScoreA() < g.getScoreB() && g.getState() == "finished") victories ++;
            else if (g.getTeams().get(1).name == this.name && g.getScoreB() < g.getScoreA() && g.getState() == "finished") victories ++;
        }
        return victories;
    }

    public int countSame() {
        int victories = 0;
        for (Game g : this.games) {
            if (g.getTeams().get(0).name == this.name && g.getScoreA() == g.getScoreB() && g.getState() == "finished") victories ++;
            else if (g.getTeams().get(1).name == this.name && g.getScoreB() == g.getScoreA() && g.getState() == "finished") victories ++;
        }
        return victories;
    }

    public int countGames() {
        return this.games.size();
    }

}
