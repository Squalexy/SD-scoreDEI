package com.example.demo.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class User {

    @Getter
    @Setter

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String username, password, email, telephone;
    private boolean isAdmin;

    public User(){}

    public User(String username, String password, String email, String telephone, boolean isAdmin){
        this.username = username;
        this.password = password;
        this.email = email;
        this.telephone = telephone;
        this.isAdmin = isAdmin;
    }

    @Override public String toString(){

        String type;
        if (this.isAdmin) type = "Admin";
        else type = "User";

        return String.format("""
                            Username: %s%n
                            Email: %s%n
                            Telephone: %s%n
                            Type: %s%n
                            """, this.username, this.email, this.telephone, type);
    }

}
