package com.example.toDoApp.repository;

import com.example.toDoApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
