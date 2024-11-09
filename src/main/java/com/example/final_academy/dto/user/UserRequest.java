package com.example.final_academy.dto.user;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRequest {
    Long id;
    String fullName;
    String email;
    String phone;
    String username;
    String password;
}
