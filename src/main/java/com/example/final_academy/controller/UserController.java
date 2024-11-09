package com.example.final_academy.controller;

import com.example.final_academy.dto.ApiResponse;
import com.example.final_academy.dto.login.LoginRequest;
import com.example.final_academy.dto.login.LoginResponse;
import com.example.final_academy.dto.user.UserRequest;
import com.example.final_academy.dto.user.UserResponse;
import com.example.final_academy.mapper.IUserMapper;
import com.example.final_academy.modal.User;
import com.example.final_academy.service.IUserService;
import com.example.final_academy.service.Impl.UserService;
import com.example.final_academy.util.JsonResponse;
import com.example.final_academy.util.JwtUtil;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    @Autowired
    IUserService userService;

    @Autowired
    IUserMapper iUserMapper;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserService userDetailsService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<UserResponse>> save(@RequestBody UserRequest req) {
        User user = iUserMapper.userRequestToUser(req);
        userService.save(user);
        return JsonResponse.create(iUserMapper.userToUserResponse(user));
    }

    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginRequest authRequest) throws Exception {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
        );

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails.getUsername());

        return ResponseEntity.ok(new LoginResponse(jwt));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<UserResponse>> update(@RequestBody UserRequest req,
                                                            @PathVariable(name = "id") Long userId) {
        User user = iUserMapper.userRequestToUser(req);
        userService.update(user,userId);
        return JsonResponse.ok(iUserMapper.userToUserResponse(user));
    }
}
