package com.example.final_academy.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public enum ErrorCode {
    USER_NOT_FOUND(4001,"user not found",HttpStatus.NOT_FOUND),
    SERVICE_NOT_FOUND(4002,"Service not found",HttpStatus.NOT_FOUND),
    HOME_LAND_NOT_FOUND(4003,"Home land not found",HttpStatus.NOT_FOUND)
    ;
    Integer code;
    String message;
    HttpStatus status;
}
