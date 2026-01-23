package com.khanh.clinic_management.api.auth.service;

import com.khanh.clinic_management.api.auth.dto.request.LoginRequest;
import com.khanh.clinic_management.api.auth.dto.request.RegisterRequest;
import com.khanh.clinic_management.api.auth.dto.response.AuthResponse;

public interface AuthService {
    AuthResponse register(RegisterRequest request);
    AuthResponse login(LoginRequest request);
}
