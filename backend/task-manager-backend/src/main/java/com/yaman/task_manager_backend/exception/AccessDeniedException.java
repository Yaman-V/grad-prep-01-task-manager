package com.yaman.task_manager_backend.exception;

public class AccessDeniedException extends RuntimeException {
    public AccessDeniedException() {
        super("Access denied: require Admin");
    }
}
