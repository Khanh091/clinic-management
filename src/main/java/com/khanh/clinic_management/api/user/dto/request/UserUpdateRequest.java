package com.khanh.clinic_management.api.user.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateRequest {
    private String name;
    private String phone;
    private String avatar;
}
