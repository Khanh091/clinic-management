package com.khanh.clinic_management.api.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    @Column(nullable = false, unique = true)
    private String email;
    private String phone;
    private String avatar;
    @Column(nullable = false)
    private String password;
    private String role;

}
