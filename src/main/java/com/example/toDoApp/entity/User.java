package com.example.toDoApp.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    @OneToMany(cascade = CascadeType.ALL)

    private List<ToDo> toDoList = new ArrayList<>();

    public User() {
    }
    public String getUsername() {
        return username;
    }

    public User(String username, String password, List<ToDo> toDoList) {
        this.username = username;
        this.password = password;
        this.toDoList = toDoList;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<ToDo> getToDoList() {
        return toDoList;
    }

    public void setToDoList(List<ToDo> toDoList) {
        this.toDoList = toDoList;
    }


}
