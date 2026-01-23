package com.khanh.clinic_management.api.user.service;

import com.khanh.clinic_management.api.user.dto.request.UserUpdateRequest;
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

    @Override
    public List<UserResponse> searchUser(String name) {
        List<UserResponse> lst = new ArrayList<>();
        List<User> users = repo.findAll();
        for(User user : users){
            if(user.getName().toLowerCase().contains(name.toLowerCase())){
                lst.add(toUserResponse(user));
            }
        }
        return lst;
    }

    @Override
    public UserResponse updateUser(int id, UserUpdateRequest request) {
        User user = repo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        user.setName(request.getName());
        user.setPhone(request.getPhone());
        user.setAvatar(request.getAvatar());
        repo.save(user);
        return toUserResponse(user);
    }

    @Override
    public UserResponse deleteUser(int id) {
        User user = repo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        repo.delete(user);
        return toUserResponse(user);
    }

}
