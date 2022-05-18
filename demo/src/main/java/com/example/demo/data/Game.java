package com.example.demo.data;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Game {

    @Getter
    @Setter

    private String localization;
    private int scoreA;
    private int scoreB;
    private Timestamp startDate;
    private Team teamA;
    private Team teamB;
    @OneToMany(mappedBy="game")
    private List <Event> events;

    public Game(){}

    public Game(String localization, Timestamp startDate){
        this.localization = localization;
        this.startDate = startDate;
    }
 
    @Override public String toString(){
        String start = new SimpleDateFormat("dd/MM/yyyy HH:mm::ss").format(startDate);
        return String.format("""
                            %s vs %s%n
                            Score: %s-%s%n
                            Started: %s%n
                            Localization: %s%n
                            """, this.teamA, this.teamB, this.scoreA, this.scoreB, start, this.localization);
    }

}
