package com.khanh.clinic_management.api.auth.service;

import com.khanh.clinic_management.api.auth.dto.request.LoginRequest;
import com.khanh.clinic_management.api.auth.dto.request.RegisterRequest;
import com.khanh.clinic_management.api.auth.dto.response.AuthResponse;
import com.khanh.clinic_management.api.user.entity.User;
import com.khanh.clinic_management.api.user.repository.UserRepository;
import com.khanh.clinic_management.api.auth.util.JwtUtil;
import com.khanh.clinic_management.exception.BadRequestException;
import com.khanh.clinic_management.exception.UnauthorizedException;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {
    
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Override
    public AuthResponse register(RegisterRequest request) {
        //kiểm tra email đã tồn tại chưa
        Optional<User> existingUser = userRepository.findByEmail(request.getEmail());
        if (existingUser.isPresent()) {
            throw new BadRequestException("Email already exists");
        }

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole("USER"); // Default role

        User savedUser = userRepository.save(user);

        //tạo JWT token
        String accessToken = jwtUtil.generateToken(savedUser.getEmail());
        String refreshToken = jwtUtil.generateRefreshToken(savedUser.getEmail());

        return new AuthResponse(
            accessToken,
            refreshToken,
            "Bearer",
            60 // 1p
        );
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
            .orElseThrow(() -> new UnauthorizedException("Invalid email or password"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new UnauthorizedException("Invalid email or password");
        }

        String accessToken = jwtUtil.generateToken(user.getEmail());
        String refreshToken = jwtUtil.generateRefreshToken(user.getEmail());

        return new AuthResponse(
            accessToken,
            refreshToken,
            "Bearer",
            60 //1h
        );
    }

    @Override
    public AuthResponse refreshToken(String refreshToken) {
        if (!jwtUtil.isTokenExpired(refreshToken)) {
            throw new UnauthorizedException("Token is not expired yet");
        }

        String email = jwtUtil.extractEmail(refreshToken);
        String newAccessToken = jwtUtil.generateToken(email);
        String newRefreshToken = jwtUtil.generateRefreshToken(email);

        return new AuthResponse(
            newAccessToken,
            newRefreshToken,
            "Bearer",
            60 //1p
        );
    }
}
