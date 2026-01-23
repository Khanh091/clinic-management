package com.khanh.clinic_management.api.user.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {
    private Integer id;
    private String name;
    private String email;
    private String phone;
    private String avatar;
}
