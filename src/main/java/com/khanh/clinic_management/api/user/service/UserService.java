package com.khanh.clinic_management.api.user.service;

import com.khanh.clinic_management.api.user.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public List<User> getAllUsers();
    public User getUserById(int id);
}
