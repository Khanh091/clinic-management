package com.khanh.clinic_management.api.user.service;

import com.khanh.clinic_management.api.user.dto.request.UserUpdateRequest;
import com.khanh.clinic_management.api.user.dto.response.UserResponse;
import com.khanh.clinic_management.api.user.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    public List<UserResponse> getAllUsers();
    public UserResponse getUserById(int id);
    public List<UserResponse> searchUser(String name);
    public UserResponse updateUser(int id, UserUpdateRequest request);
    public UserResponse deleteUser(int id);
}
