package com.khanh.clinic_management.api.user;

import com.khanh.clinic_management.api.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
@Validated
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping()
    public ResponseEntity<?> getListUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
    @PostMapping()
    public ResponseEntity<?> createUser() {
        return ResponseEntity.ok("Create user successfully");
    }
    @PutMapping("/{id}" )
    public ResponseEntity<?> updateUser(@PathVariable Long id) {
        return ResponseEntity.ok("Update user successfully");
    }

}
