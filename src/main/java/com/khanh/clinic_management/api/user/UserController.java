package com.khanh.clinic_management.api.user;

import com.khanh.clinic_management.api.user.dto.request.UserUpdateRequest;
import com.khanh.clinic_management.api.user.service.UserService;
import com.khanh.clinic_management.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAnyRole('ADMIN', 'USER', 'DOCTOR', 'STAFF')")
    public ResponseEntity<?> getListUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
    
    @PostMapping()
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> createUser() {
        return ResponseEntity.ok("Create user successfully");
    }
    
    @GetMapping("/{id}" )
    @PreAuthorize("hasAnyRole('ADMIN', 'USER', 'DOCTOR', 'STAFF')")
    public ResponseEntity<?> getUserById(@PathVariable Integer id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }
    
    @GetMapping("/search")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER', 'DOCTOR', 'STAFF')")
    public ResponseEntity<?> searchUsers(@RequestParam(required = false, defaultValue = "") String keyword) {
        return ResponseEntity.ok(userService.searchUser(keyword));
    }
    
    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<?> updateUser(@PathVariable Integer id, @RequestBody UserUpdateRequest request) {
        return ResponseEntity.ok(userService.updateUser(id,request));
    }
    
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id) {
        return ResponseEntity.ok(userService.deleteUser(id));
    }


}
