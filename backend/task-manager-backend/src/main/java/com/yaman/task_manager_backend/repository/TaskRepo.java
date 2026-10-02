package com.yaman.task_manager_backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.yaman.task_manager_backend.model.Task;

public interface TaskRepo extends JpaRepository<Task, Integer> {
    
}
