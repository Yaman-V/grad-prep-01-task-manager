package com.yaman.task_manager_backend.service;

import com.yaman.task_manager_backend.dto.TaskCreateRequestDTO;
import com.yaman.task_manager_backend.dto.TaskResponseDTO;
import com.yaman.task_manager_backend.exception.ProjectAccessDeniedException;
import com.yaman.task_manager_backend.mapper.TaskMapper;
import com.yaman.task_manager_backend.model.Project;
import com.yaman.task_manager_backend.model.Task;
import com.yaman.task_manager_backend.repository.TaskRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class TaskService {
    // This Service depended on ProjectService never makes ProjectServie depend on this one, or you will create circular dependency.
    // If you have to make that, make a new shared service.
    private final TaskRepo taskRepo;
    private final TaskMapper mapper;
    private final ProjectService projectService;


    public TaskService(TaskRepo taskRepo, TaskMapper mapper, ProjectService projectService) {
        this.taskRepo = taskRepo;
        this.mapper = mapper;
        this.projectService = projectService;
    }

    public TaskResponseDTO createTask(String email, Integer projectID, TaskCreateRequestDTO requestDTO) {
        Project project = requireAdmin(email, projectID);

        Task task = new Task();
        task.setProject(project);
        task.setTitle(requestDTO.title());
        task.setDescription(requestDTO.description());
        task.setDueDate(requestDTO.dueDate());
        task.setCreatedAt(LocalDateTime.now());

        Task saved = taskRepo.save(task);
        return mapper.toTaskResponseDTO(saved);
    }

    public Project requireAdmin(String email, Integer projectID) {
        Project project = projectService.requireMemberProject(email, projectID);
        if (!project.getAdmin().getEmail().equals(email))
            throw new ProjectAccessDeniedException();
        return project;
    }
}
