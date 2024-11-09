package com.example.final_academy.service.Impl;

import com.example.final_academy.modal.MyUserDetails;
import com.example.final_academy.modal.User;
import com.example.final_academy.repository.IUserRepository;
import com.example.final_academy.repository.Impl.UserRepository;
import com.example.final_academy.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService, UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    IUserRepository iUserRepository;

    public User save(User req) {
        return userRepository.save(req);
    }

    public User update(User req, Long userId) {
        return userRepository.update(req, userId);
    }

    public User findByUsername(String username) {
        return iUserRepository.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = iUserRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new MyUserDetails(user);  // Sử dụng MyUserDetails như đã định nghĩa trước
    }
}
