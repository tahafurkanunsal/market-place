package com.tfunsal.marketplace.service.user;

import com.tfunsal.marketplace.dto.UserDto;
import com.tfunsal.marketplace.model.User;
import com.tfunsal.marketplace.request.CreateUserRequest;
import com.tfunsal.marketplace.request.UpdateUserRequest;

public interface UserService {

    User getUserById(Long userId);

    User createUser(CreateUserRequest createUserRequest);

    User updateUser(Long userId, UpdateUserRequest updateUserRequest);

    void deleteUser(Long userId);

    UserDto convertUserToDto(User user);
}
