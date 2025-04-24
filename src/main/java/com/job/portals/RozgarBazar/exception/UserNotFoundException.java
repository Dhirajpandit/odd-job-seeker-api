package com.job.portals.RozgarBazar.exception;


public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long workerId) {
        super("Worker not found with ID: " + workerId);
    }
}
