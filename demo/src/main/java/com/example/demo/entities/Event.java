package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

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

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startEvent;
    private String startEventTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endEvent;
    private String endEventTime;

    @ManyToOne()
    private Game game;

    @ManyToOne()
    private Player player;

    public Event(){}

    // (a) start and end game
    public Event(String name, Date startEvent,  String startEventTime, Date endEvent, String endEventTime){
        this.name = name;
        this.startEvent = startEvent;
        this.startEventTime = startEventTime;
        this.endEventTime = endEventTime;
        this.endEvent = endEvent;
        this.description = String.format("[%s %s] Start: %s %s --- Ends: %s %s", this.startEvent, this.startEventTime, this.startEvent, this.startEventTime, this.endEvent, this.endEventTime);
    }

    // (b), (c) and (d) goals and cards
    public Event(String name, Date startEvent, String startEventTime, Player player){
        this.name = name;
        this.startEvent = startEvent;
        this.startEventTime = startEventTime;
        this.player = player;

        if (this.name.equals("b")) this.description = String.format("[%s %s] Player %s scored a goal!", this.startEvent, this.startEventTime, this.player.getName());
        else if (this.name.equals("c"))this.description = String.format("[%s %s] Player %s received a yellow card!", this.startEvent, this.startEventTime, this.player.getName());
        else if (this.name.equals("d"))this.description = String.format("[%s %s] Player %s received a red card!", this.startEvent, this.startEventTime, this.player.getName());
        
    }

    // (e) and (f)
    public Event(String name, Date startEvent, String startEventTime){
        this.name = name;
        this.startEvent = startEvent;
        this.startEventTime = startEventTime;

        if (this.name.equals("e")) this.description = String.format("[%s %s] Game paused.", this.startEvent, this.startEventTime);
        else if (this.name.equals("f")) this.description = String.format("[%s %s] Game resumed.", this.startEvent, this.startEventTime);
    
    }


    public void setTheDescription(){

        if (this.name.equals("a")) this.description = String.format("[%s %s] Start: %s %s --- Ends: %s %s", this.startEvent, this.startEventTime, this.startEvent, this.startEventTime, this.endEvent, this.endEventTime);
        else if (this.name.equals("b")) this.description = String.format("[%s %s] Player %s scored a goal!", this.startEvent, this.startEventTime, this.player.getName());
        else if (this.name.equals("c"))this.description = String.format("[%s %s] Player %s received a yellow card!", this.startEvent, this.startEventTime, this.player.getName());
        else if (this.name.equals("d"))this.description = String.format("[%s %s] Player %s received a red card!", this.startEvent, this.startEventTime, this.player.getName());
        else if (this.name.equals("e")) this.description = String.format("[%s %s] Game paused.", this.startEvent, this.startEventTime);
        else if (this.name.equals("f")) this.description = String.format("[%s %s] Game resumed.", this.startEvent, this.startEventTime);

    }
}