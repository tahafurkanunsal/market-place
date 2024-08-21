package com.tfunsal.marketplace.service.user;

import com.tfunsal.marketplace.dto.UserDto;
import com.tfunsal.marketplace.exceptions.AlreadyExistsException;
import com.tfunsal.marketplace.exceptions.ResourceNotFoundException;
import com.tfunsal.marketplace.model.User;
import com.tfunsal.marketplace.repository.UserRepository;
import com.tfunsal.marketplace.request.CreateUserRequest;
import com.tfunsal.marketplace.request.UpdateUserRequest;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
    }

    @Override
    public User createUser(CreateUserRequest createUserRequest) {
        return Optional.of(createUserRequest).filter(user -> !userRepository.existsByEmail(createUserRequest.getEmail()))
                .map(request -> {
                    User user = new User();
                    user.setFirstName(request.getFirstName());
                    user.setLastName(request.getLastName());
                    user.setEmail(request.getEmail());
                    user.setPassword(request.getPassword());
                    return userRepository.save(user);
                }).orElseThrow(() -> new AlreadyExistsException("Oops!" + createUserRequest.getEmail() + " already exists!"));
    }

    @Override
    public User updateUser(Long userId, UpdateUserRequest updateUserRequest) {
        return userRepository.findById(userId).map(existingUser -> {
            existingUser.setFirstName(updateUserRequest.getFirstName());
            existingUser.setLastName(updateUserRequest.getLastName());
            return userRepository.save(existingUser);
        }).orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.findById(userId)
                .ifPresentOrElse(userRepository::delete, () -> {
                    throw new ResourceNotFoundException("User not found with id: " + userId);
                });
    }

    @Override
    public UserDto convertUserToDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }
}
