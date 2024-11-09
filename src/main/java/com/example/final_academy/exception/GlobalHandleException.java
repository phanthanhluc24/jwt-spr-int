package com.example.final_academy.exception;

import com.example.final_academy.dto.ApiResponse;
import com.example.final_academy.modal.HomeLand;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandleException {
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<?> handlingApiException (ApiException exception) {
        ErrorCode errorCode = exception.getErrorCode();

        return ResponseEntity.status(errorCode.getStatus()).body(ApiResponse.<HomeLand>builder()
                .code(errorCode.getCode())
                .message(errorCode.getMessage())
                .build()
        );


    }
}
