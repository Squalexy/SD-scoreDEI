package com.example.demo.classes;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Game {

    private String localization;
    private int scoreA;
    private int scoreB;

    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private Date startDate;

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
