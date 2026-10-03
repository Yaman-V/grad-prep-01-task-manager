package com.yaman.task_manager_backend.service;

import com.yaman.task_manager_backend.dto.UserRequestDTO;
import com.yaman.task_manager_backend.dto.UserResponseDTO;
import com.yaman.task_manager_backend.exception.UserAlreadyExistsException;
import com.yaman.task_manager_backend.mapper.UserMapper;
import com.yaman.task_manager_backend.model.User;
import com.yaman.task_manager_backend.repository.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserMapper mapper;
    private final UserRepo userRepo;

    public UserService(UserRepo userRepo, UserMapper userMapper) {
        this.userRepo = userRepo;
        this.mapper = userMapper;
    }

    public UserResponseDTO signUp(UserRequestDTO requestDTO) {
        User newUser = mapper.toUser(requestDTO);
        if (userRepo.existsById(newUser.getEmail())) {
            throw new UserAlreadyExistsException("User Already Exists!");
        }

        User saved = userRepo.save(newUser);
        return mapper.toUserResponseDTO(saved);
    }

}
