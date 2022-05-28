package com.example.demo.repositories;

import java.util.List;
import com.example.demo.entities.Team;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository<Team, Integer> {

    @Query("SELECT t FROM Team t ORDER BY t.name ASC")
    public List<Team> retrieveTeams();
}    