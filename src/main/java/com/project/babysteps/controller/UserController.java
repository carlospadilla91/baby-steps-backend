package com.project.babysteps.controller;

import com.project.babysteps.dto.UserDto;
import com.project.babysteps.dto.mappers.UserMapper;
import com.project.babysteps.model.User;
import com.project.babysteps.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/me")
    public ResponseEntity<UserDto> getUser(@AuthenticationPrincipal UserDetails userDetails) {
        Optional<User> user = userService.getUserByEmail(userDetails.getUsername());

        return user.map(value -> ResponseEntity.ok(UserMapper.toDto(value)))
                .orElse(ResponseEntity.notFound().build());
    }

}
