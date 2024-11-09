package com.example.final_academy.repository;

import com.example.final_academy.modal.TypeService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IServiceRepository extends JpaRepository<TypeService,Long> {
    Optional<TypeService> findByService(String name);
}
