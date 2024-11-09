package com.example.final_academy.dto.homeLand;

import com.example.final_academy.modal.TypeService;
import com.example.final_academy.modal.User;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HomeLandResponse {
    Double price;
    Integer spaceLand;
    Long userId;
    Long serviceId;
}
