package com.yaman.task_manager_backend.controller;

import com.yaman.task_manager_backend.dto.UserRequestDTO;
import com.yaman.task_manager_backend.dto.UserResponseDTO;
import com.yaman.task_manager_backend.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService service;

    public  UserController(UserService service){
        this.service =service;
    }

    @PostMapping("/users/signup")
    public ResponseEntity<UserResponseDTO> SignUp(@Valid @RequestBody UserRequestDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.signUp(dto));
    }
}
