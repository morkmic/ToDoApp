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
public class ToDoAppApplication{// implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ToDoRepository toDoRepository;

    public static void main(String[] args) {
        SpringApplication.run(ToDoAppApplication.class, args);
    }

    // @Override
    // public void run(String... args) throws Exception {
    //     User user = new User();
    //     user.setPassword("pass1");
    //     user.setUsername("John");
    //
    //     ToDo toDo = new ToDo();
    //     toDo.setContent("Upload to YT");
    //
    //     user.getToDoList().add(toDo);
    //     toDoRepository.save(toDo);
    //     userRepository.save(user);
    // }
}
