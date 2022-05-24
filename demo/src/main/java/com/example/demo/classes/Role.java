package com.example.demo.classes;
 
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
 
@Entity
@Getter
@Setter
@Table(name = "roles")
public class Role {
    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
     
    private String name;

    public Role(){}

    public Role(String name){
        this.name = name;
    }

    public Integer getId() {
        return id;
    }
}