package com.project.babysteps.service;

import com.project.babysteps.dto.UserDto;
import com.project.babysteps.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDto createUser(UserDto userDto);
    Optional<UserDto> getUserById(Long id);
    Optional<UserDto> getUserByEmail(String email);
    List<UserDto> getAllUsers();
    UserDto updateUser(Long id, UserDto userDto);
    void deleteUser(Long id);
}
