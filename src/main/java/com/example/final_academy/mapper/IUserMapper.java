package com.example.final_academy.mapper;

import com.example.final_academy.dto.user.UserRequest;
import com.example.final_academy.dto.user.UserResponse;
import com.example.final_academy.modal.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface IUserMapper {
    UserResponse userToUserResponse(User user);
    User userRequestToUser(UserRequest request);
}
