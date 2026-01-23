package com.khanh.clinic_management.api.user.repository;

import com.khanh.clinic_management.api.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

}
