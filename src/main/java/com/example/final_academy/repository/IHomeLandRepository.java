package com.example.final_academy.repository;

import com.example.final_academy.modal.HomeLand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IHomeLandRepository extends JpaRepository<HomeLand,Long> {
    @Query(value = "SELECT hl.* FROM home_lands hl " +
            "JOIN users u ON u.id = hl.user_id " +
            "JOIN services s ON s.id = hl.service_id " +
            "WHERE hl.id = :id", nativeQuery = true)
    HomeLand findHomeLandDetailById(@Param("id") Long id);

}
