package com.khanh.clinic_management.api.logs;

import com.khanh.clinic_management.api.logs.entity.Logs;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/logs")
@AllArgsConstructor
@Validated
public class LogsController {
    @PostMapping("/get-logs")
    public ResponseEntity<?> getLogs() {
        Logs l = new Logs(1L);
        return ResponseEntity.status(HttpStatus.OK).body(l);
    }


}
