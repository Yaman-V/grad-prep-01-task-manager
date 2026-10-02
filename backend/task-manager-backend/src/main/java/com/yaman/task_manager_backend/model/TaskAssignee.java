package com.yaman.task_manager_backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TaskAssignee", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "taskId", "projectMemberId" })
})
public class TaskAssignee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "taskId", nullable = false)
    private Task task;

    @ManyToOne
    @JoinColumn(name = "projectMemberId", nullable = false)
    private ProjectMember projectMember;

}
