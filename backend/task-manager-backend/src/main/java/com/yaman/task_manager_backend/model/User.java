package com.yaman.task_manager_backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "User")
public class User {

    @Id
    private String email;

    @Column(name = "username", nullable = false, length = 35)
    private String username;

    @Column(name = "password", nullable = true, length = 255)
    private String password;

}