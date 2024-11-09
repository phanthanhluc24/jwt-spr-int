package com.example.final_academy.dto.homeLand;

import com.example.final_academy.dto.user.UserRequest;
import com.example.final_academy.modal.TypeService;
import com.example.final_academy.modal.User;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HomeLandRequest {
    Double price;
    Integer spaceLand;
    Long userId;
    Long serviceId;
}
