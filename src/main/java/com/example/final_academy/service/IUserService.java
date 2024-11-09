package com.example.final_academy.service;


import com.example.final_academy.modal.User;
import org.springframework.stereotype.Component;

@Component
public interface IUserService {
    User save(User req);
    User update(User req, Long userId);
}
