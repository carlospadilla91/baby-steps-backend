package com.project.babysteps.service;

import com.project.babysteps.dto.AuthRequest;
import com.project.babysteps.dto.AuthResponse;
import com.project.babysteps.dto.CreateUserDto;

public interface AuthService {
    AuthResponse register(CreateUserDto request);
    AuthResponse authenticate(AuthRequest request);

}
