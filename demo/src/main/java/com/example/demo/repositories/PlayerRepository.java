package com.example.demo.repositories;

import java.util.List;
import com.example.demo.entities.Player;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<Player, Integer> {

    @Query("SELECT p FROM Player p ORDER BY p.name ASC")
    public List<Player> retrievePlayers();

    @Query("SELECT p FROM Player p WHERE p.nGoals = (SELECT MAX(nGoals) FROM Player)")
    public List<Player> findBestPlayers();
}    