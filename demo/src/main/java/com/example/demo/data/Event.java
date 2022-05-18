package com.example.demo.data;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Event {

    @Getter
    @Setter

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private Timestamp startEvent;
    private Timestamp endEvent;
    @OneToMany(cascade = CascadeType.ALL)
    private Game game;
    @OneToMany(mappedBy = "events")
    private Player player;

    public Event(){}

    // (a) start and end game
    public Event(String name, Timestamp startEvent, Timestamp endEvent){
        this.name = name;
        this.startEvent = startEvent;
        this.endEvent = endEvent;
    }

    // (b), (c) and (d) goals and cards
    public Event(String name, Timestamp startEvent, Player player){
        this.name = name;
        this.startEvent = startEvent;
        this.player = player;
    }

    // (e) and (f)
    public Event(String name, Timestamp startEvent){
        this.name = name;
        this.startEvent = startEvent;
    }
 
    public String toString(){

        String start = new SimpleDateFormat("dd/MM/yyyy HH:mm::ss").format(this.startEvent);
        String end = new SimpleDateFormat("dd/MM/yyyy HH:mm::ss").format(this.endEvent);

        switch (this.name){
            case "a": return String.format("Begins: %s%nEnds: %s%n", start, end);
            case "b": return String.format("[%s] Player %s scored a goal!", start, this.player);
            case "c": return String.format("[%s]Player %s got a yellow card!", start, this.player);
            case "d": return String.format("[%s]Player %s got a red card!", start, this.player);
            case "e": return String.format("[%s]Game paused!", start);
            case "f": return String.format("[%s]Game resumed!", start); 
            default: return "error switch case";
        }

        
    }

}