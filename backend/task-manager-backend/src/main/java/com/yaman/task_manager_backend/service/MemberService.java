package com.yaman.task_manager_backend.service;

import com.yaman.task_manager_backend.dto.MemberCreateRequestDTO;
import com.yaman.task_manager_backend.dto.MemberResponseDTO;
import com.yaman.task_manager_backend.exception.UserAlreadyExistsException;
import com.yaman.task_manager_backend.exception.UserNotFound;
import com.yaman.task_manager_backend.mapper.MemberMapper;
import com.yaman.task_manager_backend.model.Project;
import com.yaman.task_manager_backend.model.ProjectMember;
import com.yaman.task_manager_backend.model.User;
import com.yaman.task_manager_backend.repository.ProjectMemberRepo;
import com.yaman.task_manager_backend.repository.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class MemberService {
    private final UserRepo userRepo;
    private final ProjectMemberRepo projectMemberRepo;
    private final MemberMapper mapper;
    private final TaskService taskService;

    public MemberService(UserRepo userRepo, ProjectMemberRepo projectMemberRepo, MemberMapper mapper,TaskService taskService) {
        this.userRepo = userRepo;
        this.projectMemberRepo = projectMemberRepo;
        this.mapper = mapper;
        this.taskService = taskService;
    }

    @Transactional
    public MemberResponseDTO addMemberToProject(String email, Integer projectID, MemberCreateRequestDTO requestDTO) {
        Project project = taskService.requireAdmin(email, projectID);
        User user = requireUser(requestDTO.email());
        if (isMemberOfProject(requestDTO.email(), projectID)) {
            throw new UserAlreadyExistsException("User already in the project");
        }

        ProjectMember pm = new ProjectMember();
        pm.setUser(user);
        pm.setProject(project);
        pm.setJoinedAt(LocalDateTime.now());

        ProjectMember saved = projectMemberRepo.save(pm);

        return mapper.toMemberResponseDTO(saved);

    }

    private User requireUser(String email) {
        return userRepo.findById(email).
                orElseThrow(UserNotFound::new);
    }

    private boolean isMemberOfProject(String email, Integer projectID) {
        Optional<Project> project =  projectMemberRepo.findProjectIfMember(projectID, email);
        return project.map(value -> value.getId().equals(projectID))
                .orElse(false); // not exiting in any project or not in the targeted project.
    }
}
