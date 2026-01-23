package com.khanh.clinic_management.api.user.mapper;

import com.khanh.clinic_management.api.user.dto.response.UserResponse;
import com.khanh.clinic_management.api.user.entity.User;

public class UserMapper {
    public static UserResponse toUserResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .avatar(user.getAvatar())
                .build();
    }
}
