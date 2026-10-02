package com.yaman.task_manager_backend.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity 
@Table (name = "Project")
public class Project {
    
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn (name = "admin", nullable = false)
    private Users admin;

    @Column (
        name = "title",
        length = 35,
        nullable = false
    )
    private String title;

    @Column (
        name = "createdAt",
        nullable = false
    )
    private LocalDateTime createdAt;

}
