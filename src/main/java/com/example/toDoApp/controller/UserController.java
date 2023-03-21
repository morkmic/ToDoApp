package com.example.toDoApp.controller;

import com.example.request.AddToDoRequest;
import com.example.request.AddUserRequest;
import com.example.toDoApp.entity.User;
import com.example.toDoApp.entity.ToDo;
import com.example.toDoApp.repository.ToDoRepository;
import com.example.toDoApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ToDoRepository toDoRepository;

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException());
    }
    @GetMapping("/todos/{toDoId}")
    public ToDo getToDoById(@PathVariable Long toDoId) {
        return toDoRepository.findById(toDoId).orElseThrow(() -> new NoSuchElementException());
    }
    @GetMapping
    public List getUsers() {
       return userRepository.findAll();
    }
    @PostMapping
    public User adduser(@RequestBody AddUserRequest userRequest) {
        User user = new User();
        user.setUsername(userRequest.getUsername());
        user.setPassword(userRequest.getPassword());
        return userRepository.save(user);
    }

    @PostMapping("/{userId}/todos")
    public void addTodo(@PathVariable Long userId, @RequestBody AddToDoRequest toDoRequest) {
        User user = userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException());
        ToDo toDo = new ToDo();
        toDo.setContent(toDoRequest.getContent());
        user.getToDoList().add(toDo);
        toDoRepository.save(toDo);
        userRepository.save(user);
    }

    @PutMapping("/todos/{toDoId}")
    public void toggleToDoCompleted(@PathVariable Long toDoId){
        ToDo todo = toDoRepository.findById(toDoId).orElseThrow(() -> new NoSuchElementException());
        todo.setCompleted(!todo.getCompleted());
        toDoRepository.save(todo);
    }
    @DeleteMapping("{userId}/todos/{toDoId}")
    public void deleteToDo(@PathVariable Long userId, @PathVariable Long toDoId){
        User user = userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException());
        ToDo toDo = toDoRepository.findById(toDoId).orElseThrow(() -> new NoSuchElementException());
        user.getToDoList().remove(toDo);
        toDoRepository.delete(toDo);
    }
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId){
        User user = userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException());
        userRepository.delete(user);
    }
}