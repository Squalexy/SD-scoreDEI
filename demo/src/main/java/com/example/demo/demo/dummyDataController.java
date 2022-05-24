package com.example.demo.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.example.demo.classes.Event;
import com.example.demo.classes.Game;
import com.example.demo.classes.Player;
import com.example.demo.classes.Team;
import com.example.demo.classes.User;
import com.example.demo.classes.Role;
import com.example.demo.repositories.UserRepository;

@Controller
public class dummyDataController {

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
                new User("squelele", "sql1", "sql1@gmail.com", "966694080"),
                new User("squelele2", "sql2", "sql2@gmail.com", "966694081"),
                new User("squelele3", "sql3", "sql3@gmail.com", "966694082"),
                new User("IloveSD", "ola", "sql4@gmail.com", "966694083"),
                new User("IdontloveSD", "adeus", "sql5@gmail.com", "966694084"),
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
                new Game("Portugal", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2022-06-05 10:00:00")),
                new Game("France", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2022-06-10 12:30:00")),
                new Game("Germany", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2022-07-15 15:30:00"))
            };

        Event[] myevents = {
            new Event("a", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2022-06-05 10:00:00"), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2022-06-05 11:30:00")),
            new Event("a", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2022-06-10 12:30:00"), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2022-06-10 14:00:00")),

            // goals
            new Event("b", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2022-06-05 10:33:12"), myplayers[0]),
            new Event("b", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2022-06-05 10:45:23"), myplayers[0]),
            new Event("b", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2022-06-05 10:49:11"), myplayers[1]),
            new Event("b", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2022-06-05 10:53:12"), myplayers[4]),
            new Event("b", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2022-06-05 10:58:12"), myplayers[7]),
            new Event("b", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2022-06-05 11:03:25"), myplayers[0]),
            new Event("b", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2022-06-05 11:07:56"), myplayers[11]),
            new Event("b", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2022-06-05 11:12:09"), myplayers[0]),
            new Event("b", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2022-06-05 11:20:12"), myplayers[13]),
            new Event("b", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2022-06-05 11:25:29"), myplayers[11]),
            new Event("b", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2022-06-05 11:29:05"), myplayers[0]),

            // cards
            new Event("c", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2022-06-05 10:13:12"), myplayers[5]),
            new Event("c", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2022-06-05 10:15:23"), myplayers[9]),
            new Event("d", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2022-06-05 10:29:11"), myplayers[5]),
            new Event("c", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2022-06-05 10:58:12"), myplayers[14]),

            // interrupt and resume
            new Event("e", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2022-06-05 10:45:00")),
            new Event("f", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2022-06-05 11:00:00")),
        };

        myusers[0].addRole(myroles[0]);
        myusers[1].addRole(myroles[0]);
        myusers[2].addRole(myroles[0]);
        myusers[3].addRole(myroles[1]);
        myusers[4].addRole(myroles[0]);

        myplayers[0].addEvent(myevents[0]);
        myplayers[0].addEvent(myevents[1]);
        myplayers[1].addEvent(myevents[2]);
        myplayers[5].addEvent(myevents[4]);
        myplayers[7].addEvent(myevents[5]);
        myplayers[0].addEvent(myevents[6]);
        myplayers[11].addEvent(myevents[7]);
        myplayers[0].addEvent(myevents[8]);
        myplayers[13].addEvent(myevents[9]);
        myplayers[11].addEvent(myevents[10]);
        myplayers[0].addEvent(myevents[11]);
        myplayers[5].addEvent(myevents[12]);
        myplayers[9].addEvent(myevents[13]);
        myplayers[5].addEvent(myevents[14]);
        myplayers[14].addEvent(myevents[15]);

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

        mygames[0].addEvent(myevents[0]);
        mygames[0].addEvent(myevents[1]);
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

        mygames[0].addTeam(myteams[0]);
        mygames[0].addTeam(myteams[1]);

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

        return "redirect:/index";
    }

}
