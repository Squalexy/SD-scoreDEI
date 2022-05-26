package com.example.demo.repositories;

import com.example.demo.entities.Player;
import com.example.demo.entities.Role;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Integer> {

    @Query("SELECT r from Role r where r.name LIKE 'ADMIN'")
    public Role getAdminRole();

    @Query("SELECT r from Role r where r.name LIKE 'USER'")
    public Role getUserRole();
}    