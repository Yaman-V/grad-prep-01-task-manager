package com.yaman.task_manager_backend.controller;

import com.yaman.task_manager_backend.dto.MemberCreateRequestDTO;
import com.yaman.task_manager_backend.dto.MemberResponseDTO;
import com.yaman.task_manager_backend.security.AppUserDetails;
import com.yaman.task_manager_backend.service.MemberService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {
    private final MemberService service;

    public MemberController(MemberService service) {
        this.service = service;
    }

    @PostMapping("/projects/{projectID}/members")
    public ResponseEntity<MemberResponseDTO> addMemberToProject(@AuthenticationPrincipal AppUserDetails principal, @PathVariable Integer projectID, @Valid @RequestBody MemberCreateRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addMemberToProject(principal.getUsername(), projectID, dto));

    }
}
