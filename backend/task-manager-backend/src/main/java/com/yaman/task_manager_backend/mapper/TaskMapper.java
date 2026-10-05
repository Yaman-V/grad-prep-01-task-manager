package com.yaman.task_manager_backend.mapper;

import com.yaman.task_manager_backend.dto.toTaskResponseDTO;
import com.yaman.task_manager_backend.model.Task;
import org.springframework.stereotype.Component;


@Component
public class TaskMapper {
    public toTaskResponseDTO taskResponseDTO(Task task){
        return new toTaskResponseDTO(task.getId(), task.getTitle(), task.getStatus(),
                task.getDescription(),task.getCreatedAt(),task.getDueDate());
    }
}

