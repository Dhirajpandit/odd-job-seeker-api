package com.job.portals.RozgarBazar.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class HiringDto {
    private String message;
    private Long employerId;
    private Long jobId;
    private Long workerId;
    private LocalDateTime hireDate;

    @Data
    @Builder
    public static class WorkerInfo {
        private Long id;
        private String name;
        private Double rating;
    }

    @Data
    @Builder
    public static class JobInfo {
        private Long id;
        private String title;
    }
}
