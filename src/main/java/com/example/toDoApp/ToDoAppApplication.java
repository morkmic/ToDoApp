package com.example.toDoApp;

import com.example.toDoApp.entity.ToDo;
import com.example.toDoApp.entity.User;
import com.example.toDoApp.repository.ToDoRepository;
import com.example.toDoApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ToDoAppApplication{

    public static void main(String[] args) {
        SpringApplication.run(ToDoAppApplication.class, args);
    }

}
