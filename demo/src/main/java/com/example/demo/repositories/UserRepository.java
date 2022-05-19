package com.example.demo.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.classes.User;

public interface UserRepository extends CrudRepository<User, Integer> {
}    