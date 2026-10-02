package com.yaman.task_manager_backend.model;
import jakarta.persistence.*;
import java.time.*;

@Entity
@Table(name = "Task")
public class Task {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn (name = "projectId", nullable = false)
    private Project project;

    @Column (
        name = "title",
        length = 35,
        nullable = false
    )
    private String title;

    @Column (
        name = "description",
        columnDefinition = "TEXT",
        nullable = true
    )
    private String description;

    @Column (
        name = "status",
        nullable = false,
        length = 20
    )
    private String status;

    @Column (
        name = "dueDate",
        nullable = true
    )
    private LocalDate dueDate;

    @Column (
        name = "createdAt",
        nullable = false
    )
    private LocalDateTime createdAt;
}
