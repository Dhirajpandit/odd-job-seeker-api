package com.job.portals.RozgarBazar.model;

import lombok.Data;

@Data
public class suggestedWorker {
    private static Long JobId;
    private Long employeeId;
    private String skills;
    private String location;
}
