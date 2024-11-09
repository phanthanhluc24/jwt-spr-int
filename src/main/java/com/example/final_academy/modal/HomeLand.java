package com.example.final_academy.modal;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "home_lands")
public class HomeLand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Double price;

    @Column(name = "space_land")
    Integer spaceLand;

    @ManyToOne
    @JoinColumn(name = "service_id", referencedColumnName = "id")
    TypeService service;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    User user;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
