package com.khanh.clinic_management.api.user.service;

import com.khanh.clinic_management.api.user.dto.response.UserResponse;
import com.khanh.clinic_management.api.user.entity.User;
import com.khanh.clinic_management.api.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.khanh.clinic_management.api.user.mapper.UserMapper.toUserResponse;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repo;

    @Override
    public List<UserResponse> getAllUsers() {
        List<User> users = repo.findAll();
        List<UserResponse> lst = new ArrayList<>();
        for(User user : users){
            lst.add(toUserResponse(user));
        }
        return lst;
    }

    @Override
    public UserResponse getUserById(int id) {
        User user = repo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return toUserResponse(user) ;
    }

}
