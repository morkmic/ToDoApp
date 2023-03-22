package com.example.toDoApp.controller;

import com.example.toDoApp.service.AddToDoRequest;
import com.example.toDoApp.model.ToDo;
import com.example.toDoApp.model.User;
import com.example.toDoApp.repository.ToDoRepository;
import com.example.toDoApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/users")
public class ToDoController {


    @Autowired
    private ToDoRepository toDoRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/todos/{toDoId}")
    public ToDo getToDoById(@PathVariable Long toDoId) {
        return toDoRepository.findById(toDoId).orElseThrow(() -> new NoSuchElementException());
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

}