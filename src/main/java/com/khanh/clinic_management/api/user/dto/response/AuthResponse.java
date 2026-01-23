package com.khanh.clinic_management.api.user.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuthResponse {
    private String accessToken;
    String refreshToken;
    String tokenType;
    Integer expiresIn;
}
