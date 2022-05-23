package com.example.demo.classes;
import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private Date startEvent;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private Date endEvent;

    @OneToMany(mappedBy = "events")
    private Game game;

    @OneToMany(mappedBy="events")
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
}