package com.job.portals.RozgarBazar.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeaveRequest {
    private String startDate;
    private String endDate;
    private String reason;

    // Getters and Setters
}
