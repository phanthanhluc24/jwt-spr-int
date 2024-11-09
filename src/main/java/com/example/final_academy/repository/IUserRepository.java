package com.example.final_academy.repository;

import com.example.final_academy.modal.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);
    User findByUsername(String username);
}
