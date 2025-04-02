package com.job.portals.RozgarBazar.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Hiring {
    @NotNull(message = "Employer ID is required")
    private Long employerId;

    @NotNull(message = "Job ID is required")
    private Long jobId;

    @NotNull(message = "Worker ID is required")
    private Long workerId;

    @NotNull(message = "Hiring confirmation is required")
    private boolean hiringConfirmation;
}
