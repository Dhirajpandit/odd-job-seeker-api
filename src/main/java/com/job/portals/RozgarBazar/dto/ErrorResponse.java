package com.job.portals.RozgarBazar.dto;

import lombok.Data;

import java.time.Instant;
import java.util.Map;

@Data
public class ErrorResponse {
    private String message;
    private Map<String, String> errors;
    private Instant timestamp;

    public ErrorResponse(String message) {
        this(message, null);
    }

    public ErrorResponse(String message, Map<String, String> errors) {
        this.message = message;
        this.errors = errors;
        this.timestamp = Instant.now();
    }

}
