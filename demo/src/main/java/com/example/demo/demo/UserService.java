package com.example.demo.demo;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repositories.UserRepository;
import com.example.demo.entities.Role;
import com.example.demo.entities.User;
import com.example.demo.repositories.RoleRepository;

@Service   
public class UserService {

    @Autowired    
    private UserRepository userRepository;

    @Autowired RoleRepository roleRepository;

    public List <User> getAllUsers(){
        List <User> userRecords = new ArrayList<>();
        userRepository.retrieveUsers().forEach(userRecords::add);
        return userRecords;
    }

    public void addUser(User user)  
    {    
        userRepository.save(user);    
    }


    public void registerDefaultUser(User user){
        Role roleUser = roleRepository.getUserRole();
        user.addRole(roleUser);
        userRepository.save(user);
    }


    
    /*
    public List<Role> listRoles() {
        List <Role> listRoles = new ArrayList<>();
        roleRepository.findAll().forEach(listRoles::add);
        return listRoles;
    }
    */

    public User get(Integer id) {
        return userRepository.findById(id).get();
    }

    public int getEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public int getUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public int getTelephone(String telephone) {
        return userRepository.findByTelephone(telephone);
    }

    public int getEmailEdit(String email, String username) {
        return userRepository.findByEmailEdit(email, username);
    }

    public int getUsernameEdit(String username) {
        return userRepository.findByUsernameEdit(username);
    }

    public int getTelephoneEdit(String telephone, String username) {
        return userRepository.findByTelephoneEdit(telephone, username);
    }

    public List<Role> listRoles() {
        return (List<Role>) roleRepository.findAll();
    }
    
}
