package com.project.babysteps.service;

import com.project.babysteps.dto.UserDto;
import com.project.babysteps.dto.mappers.UserMapper;
import com.project.babysteps.model.User;
import com.project.babysteps.repository.UserRepo;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepo userRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDto createUser(UserDto dto) {
        User user = UserMapper.toEntity(dto);
        User savedUser = userRepo.save(user);
        return UserMapper.toDto(savedUser);
    }

    @Override
    public Optional<UserDto> getUserById(Long id) {
        return userRepo.findById(id)
                .map(UserMapper::toDto);
    }

    @Override
    public Optional<UserDto> getUserByEmail(String email) {
        return userRepo.findByEmail(email)
                .map(UserMapper::toDto);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepo.findAll()
                .stream()
                .map(UserMapper::toDto)
                .collect(Collectors.toList());
    }

    @SneakyThrows
    @Override
    public UserDto updateUser(Long id, UserDto dto) {

        String currentUserEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println(currentUserEmail);
        User currentUser = userRepo.findByEmail(currentUserEmail)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        if (!currentUser.getId().equals(id)) {
            throw new AccessDeniedException("You are not allowed to update this user.");
        }

        User user = userRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());

        User updatedUser = userRepo.save(user);
        return UserMapper.toDto(updatedUser);
    }

    @Override
    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }
}
