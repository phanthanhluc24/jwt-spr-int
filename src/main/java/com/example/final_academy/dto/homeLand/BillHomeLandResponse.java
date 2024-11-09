package com.example.final_academy.dto.homeLand;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BillHomeLandResponse {
    Long id;
    String service;
    String createdAt;
    Double price;
    Integer spaceLand;
    String fullName;
    Integer phone;
    String email;
}
