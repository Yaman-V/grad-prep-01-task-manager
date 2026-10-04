package com.yaman.task_manager_backend.service;

import com.yaman.task_manager_backend.dto.ProjectResponseDTO;
import com.yaman.task_manager_backend.mapper.ProjectMapper;
import com.yaman.task_manager_backend.repository.ProjectMemberRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    private final ProjectMemberRepo projectMemberRepo;
    private final ProjectMapper mapper;

    public ProjectService(ProjectMemberRepo projectMemberRepo, ProjectMapper mapper) {
        this.projectMemberRepo = projectMemberRepo;
        this.mapper = mapper;
    }

    public List<ProjectResponseDTO> getProjectsFor(String email) {
        return projectMemberRepo.findProjectsByMemberEmail(email).stream()
                .map(mapper::toProjectResponseDTO)
                .toList();
    }
}
