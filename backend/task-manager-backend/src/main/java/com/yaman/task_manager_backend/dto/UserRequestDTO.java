package com.yaman.task_manager_backend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRequestDTO(
        @NotBlank @Email String email,
        @NotBlank String username,
        @NotBlank String password
) {
}
