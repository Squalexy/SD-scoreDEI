package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@Entity
public class Event {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String description = "";

    private Date startEvent;

    private Date endEvent;

    @ManyToOne()
    private Game game;

    @ManyToOne()
    private Player player;

    public Event(){}

    // (a) start and end game
    public Event(String name, Date startEvent, Date endEvent){
        this.name = name;
        this.startEvent = startEvent;
        this.endEvent = endEvent;
        this.description = String.format("[%s] Start: %s --- Ends: %s", this.startEvent, this.startEvent, this.endEvent);
    }

    // (b), (c) and (d) goals and cards
    public Event(String name, Date startEvent, Player player){
        this.name = name;
        this.startEvent = startEvent;
        this.player = player;

        if (this.name == "b") this.description = String.format("[%s] Player %s scored a goal!", this.startEvent, this.player.getName());
        else if (this.name == "c")this.description = String.format("[%s] Player %s received a yellow card!", this.startEvent, this.player.getName());
        else if (this.name == "d")this.description = String.format("[%s] Player %s received a red card!", this.startEvent, this.player.getName());
        
    }

    // (e) and (f)
    public Event(String name, Date startEvent){
        this.name = name;
        this.startEvent = startEvent;

        if (this.name == "e") this.description = String.format("[%s] Game paused.", this.startEvent);
        else if (this.name == "f") this.description = String.format("[%s] Game resumed.", this.startEvent);
    
    }


}