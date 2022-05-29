package com.example.demo.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.example.demo.demo.EventService;
import com.example.demo.demo.GameService;
import com.example.demo.demo.PlayerService;
import com.example.demo.demo.TeamService;
import com.example.demo.demo.UserService;
import com.example.demo.entities.Event;
import com.example.demo.entities.Game;
import com.example.demo.entities.Player;
import com.example.demo.entities.Role;
import com.example.demo.entities.Team;
import com.example.demo.entities.User;

@Controller
public class controllerDummyData {

    @Autowired
    EventService eventService;
    @Autowired
    GameService gameService;
    @Autowired
    PlayerService playerService;
    @Autowired
    TeamService teamService;
    @Autowired
    UserService userService;

    @GetMapping("/createData")
    public String createData() {
        return "createData";
    }

    @PostMapping("/saveData")
    public String saveData(Model model) throws ParseException {

        Role[] myroles = {
                new Role("USER"),
                new Role("ADMIN")
        };

        User[] myusers = {
                new User("squalexy", "$2a$10$MaTB2H4OiGsS6Z.13dMBlOO2ot5o5oRrtMFQ0x5UkfRnNdlRqIC7q", "alexx.da95@gmail.com", "966694082"),
                new User("squalexy2", "$2a$10$u1XjTAxm8.3/jK/jSod3/eL2hr7ltpnnjsiNQuoRF9d9SUlzM08OG", "sql2@gmail.com", "966694081"),
                new User("squelele", "$2a$10$O2flXuCf2JY42WR/gMfhy.QKO7s7gEkeyAiMdU.KpMA7wQnRva3ay", "sql3@gmail.com", "966694085"),
                new User("IloveSD", "$2a$10$RMhOJwAEfF7pw/M2/Bhd2O8QKM5rZZoNv4D1ReKxnoYCA63/TSlk6", "sql4@gmail.com", "966694083"),
                new User("IdontloveSD", "$2a$10$tpJM6uCOTaF62nZRD5Ys3eWNJciOD4VRi8RenPq1EVwycPvizWLfu", "sql5@gmail.com", "966694084"),
        };


        Team[] myteams = {
                new Team("Africa Guppies"),
                new Team("Red Monkeys"),
                new Team("Sinister Independents"),
                new Team("Adorable Dogs"),
                new Team("Brown Mice"),
                new Team("Ample Ostriches"),
                new Team("Rude Ostriches"),
        };

        Player[] myplayers = {
                new Player("Ricardo Clark", "defesa", new SimpleDateFormat("yyyy-MM-dd").parse("1983-02-10")),
                new Player("Ryan Edmondson", "lateral", new SimpleDateFormat(("yyyy-MM-dd")).parse("2001-05-20")),
                new Player("Gonzalo Collao", "defesa", new SimpleDateFormat(("yyyy-MM-dd")).parse("1997-09-09")),
                new Player("James Finnerty", "médio", new SimpleDateFormat(("yyyy-MM-dd")).parse("1999-02-01")),
                new Player("Alexander Sebald", "lateral", new SimpleDateFormat(("yyyy-MM-dd")).parse("1996-07-27")),
                new Player("Eric Bird", "defesa", new SimpleDateFormat(("yyyy-MM-dd")).parse("1997-10-08")),
                new Player("George Marisi", "médio", new SimpleDateFormat(("yyyy-MM-dd")).parse("1996-03-06")),
                new Player("Kaj Sierhuis", "lateral", new SimpleDateFormat(("yyyy-MM-dd")).parse("1998-04-27")),
                new Player("Ass Mandaw Sy", "defesa", new SimpleDateFormat(("yyyy-MM-dd")).parse("1989-02-10")),
                new Player("Jimmy Dunne", "lateral", new SimpleDateFormat(("yyyy-MM-dd")).parse("1997-10-19")),
                new Player("Michael Langer", "guarda-redes", new SimpleDateFormat(("yyyy-MM-dd")).parse("1985-01-06")),

                new Player("Mohamed Rayhi", "defesa", new SimpleDateFormat("yyyy-MM-dd").parse("1994-07-01")),
                new Player("Marcel Hartel", "médio", new SimpleDateFormat(("yyyy-MM-dd")).parse("1986-06-18")),
                new Player("Nathaniel Atkinson", "defesa", new SimpleDateFormat(("yyyy-MM-dd")).parse("1996-01-17")),
                new Player("Toby Stevenson", "defesa", new SimpleDateFormat(("yyyy-MM-dd")).parse("1993-11-24")),
                new Player("Dennis Man", "defesa", new SimpleDateFormat(("yyyy-MM-dd")).parse("1990-12-31")),
                new Player("Erick Cabaco", "guarda-redes", new SimpleDateFormat(("yyyy-MM-dd")).parse("1992-01-01")),
                new Player("Ewan McFarlane", "lateral", new SimpleDateFormat(("yyyy-MM-dd")).parse("1987-10-29")),
                new Player("Alexandre Reis Pinto", "defesa", new SimpleDateFormat(("yyyy-MM-dd")).parse("1995-05-10")),
                new Player("Mauro Pierre Cildinho Conradi", "médio", new SimpleDateFormat(("yyyy-MM-dd")).parse("1995-05-10")),
                new Player("Liam Boyce", "lateral", new SimpleDateFormat(("yyyy-MM-dd")).parse("1998-10-04")),
                new Player("Toni Lindenhahn", "médio", new SimpleDateFormat(("yyyy-MM-dd")).parse("1990-11-15")),

                new Player("Morgan Sanson", "defesa", new SimpleDateFormat(("yyyy-MM-dd")).parse("1994-08-18")),
                new Player("Diogo da Silva Farias", "médio", new SimpleDateFormat(("yyyy-MM-dd")).parse("1990-06-13")),
        };

        Game[] mygames = {
                new Game("Portugal", new SimpleDateFormat("yyyy-MM-dd").parse("2022-06-05"), "10:00", "finished"),
                new Game("France", new SimpleDateFormat("yyyy-MM-dd").parse("2022-06-10"), "12:30", "unstarted"),
                new Game("Germany", new SimpleDateFormat("yyyy-MM-dd").parse("2022-07-15"), "15:30", "unstarted")
            };

        Event[] myevents = {
            new Event("a", new SimpleDateFormat("yyyy-MM-dd").parse("2022-06-05"), "10:00:00",  new SimpleDateFormat("yyyy-MM-dd").parse("2022-06-05"), "11:30:00"),
            new Event("a", new SimpleDateFormat("yyyy-MM-dd").parse("2022-06-10"), "12:30:00",  new SimpleDateFormat("yyyy-MM-dd").parse("2022-06-10"), "14:00:00"),

            // goals
            new Event("b", new SimpleDateFormat("yyyy-MM-dd").parse("2022-06-05"), "10:33:12",  myplayers[0]),
            new Event("b", new SimpleDateFormat("yyyy-MM-dd").parse("2022-06-05"), "10:45:23",  myplayers[0]),
            new Event("b", new SimpleDateFormat("yyyy-MM-dd").parse("2022-06-05"), "10:49:11",  myplayers[1]),
            new Event("b", new SimpleDateFormat("yyyy-MM-dd").parse("2022-06-05"), "10:53:12",  myplayers[4]),
            new Event("b", new SimpleDateFormat("yyyy-MM-dd").parse("2022-06-05"), "10:58:12",  myplayers[7]),
            new Event("b", new SimpleDateFormat("yyyy-MM-dd").parse("2022-06-05"), "11:03:25",  myplayers[0]),
            new Event("b", new SimpleDateFormat("yyyy-MM-dd").parse("2022-06-05"), "11:07:56",  myplayers[11]),
            new Event("b", new SimpleDateFormat("yyyy-MM-dd").parse("2022-06-05"), "11:12:09",  myplayers[0]),
            new Event("b", new SimpleDateFormat("yyyy-MM-dd").parse("2022-06-05"), "11:20:12",  myplayers[13]),
            new Event("b", new SimpleDateFormat("yyyy-MM-dd").parse("2022-06-05"), "11:25:29",  myplayers[11]),
            new Event("b", new SimpleDateFormat("yyyy-MM-dd").parse("2022-06-05"), "11:29:05",  myplayers[0]),

            // cards
            new Event("c", new SimpleDateFormat("yyyy-MM-dd").parse("2022-06-05"), "10:13:12",  myplayers[5]),
            new Event("c", new SimpleDateFormat("yyyy-MM-dd").parse("2022-06-05"), "10:15:23",  myplayers[9]),
            new Event("d", new SimpleDateFormat("yyyy-MM-dd").parse("2022-06-05"), "10:29:11",  myplayers[5]),
            new Event("c", new SimpleDateFormat("yyyy-MM-dd").parse("2022-06-05"), "10:58:12",  myplayers[14]),

            // interrupt and resume
            new Event("f", new SimpleDateFormat("yyyy-MM-dd").parse("2022-06-05"), "11:00:00"),
            new Event("e", new SimpleDateFormat("yyyy-MM-dd").parse("2022-06-05"), "10:45:00"),

        };

        myusers[0].addRole(myroles[1]);
        myusers[1].addRole(myroles[0]);
        myusers[2].addRole(myroles[0]);
        myusers[3].addRole(myroles[0]);
        myusers[4].addRole(myroles[0]);

        myplayers[0].addEvent(myevents[2]);
        myplayers[0].addEvent(myevents[3]);
        myplayers[1].addEvent(myevents[4]);
        myplayers[4].addEvent(myevents[5]);
        myplayers[7].addEvent(myevents[6]);
        myplayers[0].addEvent(myevents[7]);
        myplayers[11].addEvent(myevents[8]);
        myplayers[0].addEvent(myevents[9]);
        myplayers[13].addEvent(myevents[10]);
        myplayers[11].addEvent(myevents[11]);
        myplayers[0].addEvent(myevents[12]);
        myplayers[5].addEvent(myevents[13]);
        myplayers[9].addEvent(myevents[14]);
        myplayers[5].addEvent(myevents[15]);
        myplayers[14].addEvent(myevents[16]);

        myteams[0].addPlayer(myplayers[0]);
        myteams[0].addPlayer(myplayers[1]);
        myteams[0].addPlayer(myplayers[2]);
        myteams[0].addPlayer(myplayers[3]);
        myteams[0].addPlayer(myplayers[4]);
        myteams[0].addPlayer(myplayers[5]);
        myteams[0].addPlayer(myplayers[6]);
        myteams[0].addPlayer(myplayers[7]);
        myteams[0].addPlayer(myplayers[8]);
        myteams[0].addPlayer(myplayers[9]);
        myteams[0].addPlayer(myplayers[10]);

        myteams[1].addPlayer(myplayers[11]);
        myteams[1].addPlayer(myplayers[12]);
        myteams[1].addPlayer(myplayers[13]);
        myteams[1].addPlayer(myplayers[14]);
        myteams[1].addPlayer(myplayers[15]);
        myteams[1].addPlayer(myplayers[16]);
        myteams[1].addPlayer(myplayers[17]);
        myteams[1].addPlayer(myplayers[18]);
        myteams[1].addPlayer(myplayers[19]);
        myteams[1].addPlayer(myplayers[20]);
        myteams[1].addPlayer(myplayers[21]);

        myplayers[0].setTeam(myteams[0]);
        myplayers[1].setTeam(myteams[0]);
        myplayers[2].setTeam(myteams[0]);
        myplayers[3].setTeam(myteams[0]);
        myplayers[4].setTeam(myteams[0]);
        myplayers[5].setTeam(myteams[0]);
        myplayers[6].setTeam(myteams[0]);
        myplayers[7].setTeam(myteams[0]);
        myplayers[8].setTeam(myteams[0]);
        myplayers[9].setTeam(myteams[0]);
        myplayers[10].setTeam(myteams[0]);

        myplayers[11].setTeam(myteams[1]);
        myplayers[12].setTeam(myteams[1]);
        myplayers[13].setTeam(myteams[1]);
        myplayers[14].setTeam(myteams[1]);
        myplayers[15].setTeam(myteams[1]);
        myplayers[16].setTeam(myteams[1]);
        myplayers[17].setTeam(myteams[1]);
        myplayers[18].setTeam(myteams[1]);
        myplayers[19].setTeam(myteams[1]);
        myplayers[20].setTeam(myteams[1]);
        myplayers[21].setTeam(myteams[1]);

        mygames[0].addEvent(myevents[0]);
        mygames[1].addEvent(myevents[1]);
        mygames[0].addEvent(myevents[2]);
        mygames[0].addEvent(myevents[3]);
        mygames[0].addEvent(myevents[4]);
        mygames[0].addEvent(myevents[5]);
        mygames[0].addEvent(myevents[6]);
        mygames[0].addEvent(myevents[7]);
        mygames[0].addEvent(myevents[8]);
        mygames[0].addEvent(myevents[9]);
        mygames[0].addEvent(myevents[10]);
        mygames[0].addEvent(myevents[11]);
        mygames[0].addEvent(myevents[12]);
        mygames[0].addEvent(myevents[13]);
        mygames[0].addEvent(myevents[14]);
        mygames[0].addEvent(myevents[15]);
        mygames[0].addEvent(myevents[16]);
        mygames[0].addEvent(myevents[17]);
        mygames[0].addEvent(myevents[18]);

        myevents[0].setGame(mygames[0]);
        myevents[1].setGame(mygames[1]);
        myevents[2].setGame(mygames[0]);
        myevents[3].setGame(mygames[0]);
        myevents[4].setGame(mygames[0]);
        myevents[5].setGame(mygames[0]);
        myevents[6].setGame(mygames[0]);
        myevents[7].setGame(mygames[0]);
        myevents[8].setGame(mygames[0]);
        myevents[9].setGame(mygames[0]);
        myevents[10].setGame(mygames[0]);
        myevents[11].setGame(mygames[0]);
        myevents[12].setGame(mygames[0]);
        myevents[13].setGame(mygames[0]);
        myevents[14].setGame(mygames[0]);
        myevents[15].setGame(mygames[0]);
        myevents[16].setGame(mygames[0]);
        myevents[17].setGame(mygames[0]);
        myevents[18].setGame(mygames[0]);

        mygames[0].addTeam(myteams[0]);
        mygames[0].addTeam(myteams[1]);
        mygames[1].addTeam(myteams[1]);
        mygames[1].addTeam(myteams[0]);
        mygames[2].addTeam(myteams[0]);
        mygames[2].addTeam(myteams[1]);

        mygames[0].setScoreA(8); 
        mygames[0].setScoreB(3); 

        myteams[0].addGame(mygames[0]);
        myteams[1].addGame(mygames[0]);
        myteams[0].addGame(mygames[1]);
        myteams[1].addGame(mygames[1]);
        myteams[0].addGame(mygames[2]);
        myteams[1].addGame(mygames[2]);


        for (User s: myusers){
            this.userService.addUser(s);
        }

        for (Game g: mygames){
            this.gameService.addGame(g);
        }

        for (Team t: myteams){
            this.teamService.addTeam(t);
        }

        for (Player p: myplayers){
            this.playerService.addPlayer(p);
        }

        for (Event e: myevents){
            this.eventService.addEvent(e);
        }

        return "redirect:/index";
    }

}
