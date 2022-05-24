package com.example.demo.classes;

import java.util.*;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {

    @Column(name = "id")
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(unique = true)
    private String username;

    private String password;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String telephone;
    
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
            )
            
    private Set<Role> roles = new HashSet<>();

    public User(){}

    public User(String username, String password, String email, String telephone){
        this.username = username;
        this.password = password;
        this.email = email;
        this.telephone = telephone;
    }

    public void addRole(Role role){
        this.roles.add(role);
    }
}
