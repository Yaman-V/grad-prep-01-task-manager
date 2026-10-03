package com.yaman.task_manager_backend.service;

import com.yaman.task_manager_backend.dto.UserSignInRequestDTO;
import com.yaman.task_manager_backend.dto.UserResponseDTO;
import com.yaman.task_manager_backend.dto.UserSignUpRequestDTO;
import com.yaman.task_manager_backend.exception.InvalidSignIn;
import com.yaman.task_manager_backend.exception.UserAlreadyExistsException;
import com.yaman.task_manager_backend.mapper.UserMapper;
import com.yaman.task_manager_backend.model.User;
import com.yaman.task_manager_backend.repository.UserRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserMapper mapper;
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepo userRepo, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.mapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponseDTO signUp(UserSignUpRequestDTO requestDTO) {
        User newUser = mapper.toUser(requestDTO);
        if (userRepo.existsById(newUser.getEmail())) {
            throw new UserAlreadyExistsException("User Already Exists!");
        }

        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        User saved = userRepo.save(newUser);
        return mapper.toUserResponseDTO(saved);
    }

    public UserResponseDTO signIn(UserSignInRequestDTO requestDTO) {
        if (!userRepo.existsById(requestDTO.email())) {
            throw new InvalidSignIn();
        }

        User result = userRepo.getReferenceById(requestDTO.email());
        if (result.getPassword().equals(requestDTO.password())) {
            return mapper.toUserResponseDTO(result);
        }
        throw new InvalidSignIn();
    }

}
