package com.khanh.clinic_management.api.user.service;

import com.khanh.clinic_management.api.user.entity.User;
import com.khanh.clinic_management.api.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repo;

    @Override
    public List<User> getAllUsers() {
        return repo.findAll();
    }

    @Override
    public User getUserById(int id) {
        return repo.findById(id);
    }

}
