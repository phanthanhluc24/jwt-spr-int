package com.example.final_academy.repository.Impl;

import com.example.final_academy.dto.user.UserRequest;
import com.example.final_academy.modal.User;
import com.example.final_academy.repository.IUserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepository {
    @Autowired
    IUserRepository iUserRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    public User save(User req) {
        Optional<User> isExitEmail = iUserRepository.findByEmail(req.getEmail());

        if (isExitEmail.isPresent()) {
            throw new IllegalArgumentException("Email is exit");
        }

        User user = new User();
        user.setFullName(req.getFullName());
        user.setEmail(req.getEmail());
        user.setUsername(req.getUsername());
        user.setPhone(Integer.valueOf(req.getPhone()));
        user.setPassword(passwordEncoder.encode(req.getPassword()));
        return iUserRepository.save(user);
    }

    public User update(User req, Long userId) {
        return iUserRepository.findById(userId)
                .map(u -> {
                    u.setFullName(req.getFullName());
                    u.setEmail(req.getEmail());
                    u.setPhone(req.getPhone());
                    return iUserRepository.save(u);

                })
                .orElseThrow(() -> new EntityNotFoundException("user not found with id: " + userId));
    }


}
