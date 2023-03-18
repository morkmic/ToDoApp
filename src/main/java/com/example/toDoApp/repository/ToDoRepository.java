package com.example.toDoApp.repository;

import com.example.toDoApp.entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {

}
