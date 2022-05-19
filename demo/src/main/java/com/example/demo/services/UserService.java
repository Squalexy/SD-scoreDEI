package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.demo.classes.User;
import com.example.demo.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service   
public class UserService {

    @Autowired    
    private UserRepository userRepository;

    public List <User> getAllUsers(){
        List <User> userRecords = new ArrayList<>();
        userRepository.findAll().forEach(userRecords::add);
        return userRecords;
    }

    public void addUser(User user)  
    {    
        userRepository.save(user);    
    }

    public Optional<User> getUser(int id) {
        return userRepository.findById(id);
    }
    
}
