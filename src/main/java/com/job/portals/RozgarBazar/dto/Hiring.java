package com.job.portals.RozgarBazar.dto;

import lombok.Data;

// HiringRequest.java
@Data
public class Hiring {
    private Long employerId;
    private Long jobId;
    private Long workerId;
    private boolean confirmHire;
}