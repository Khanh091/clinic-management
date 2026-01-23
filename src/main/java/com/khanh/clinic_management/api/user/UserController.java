package com.khanh.clinic_management.api.user;

import com.khanh.clinic_management.api.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static com.khanh.clinic_management.api.user.mapper.UserMapper.toUserResponse;

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
    @GetMapping("/{id}" )
    public ResponseEntity<?> getUserById(@PathVariable Integer id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }
    @GetMapping("/search")
    public ResponseEntity<?> searchUsers(@RequestParam(required = false, defaultValue = "") String keyword) {
        return ResponseEntity.ok(userService.searchUser(keyword));
    }

}
