package com.example.final_academy.dto.homeLand;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateAndUpdateBillHomeLandRequest {
    Long serviceId;
    Double price;
    Integer spaceLand;
    String fullName;
    String phone;
    String email;
}
