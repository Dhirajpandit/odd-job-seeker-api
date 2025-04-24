package com.job.portals.RozgarBazar.model;

import lombok.Data;

@Data
public class SuggestedWorkerDto {
    private Long workerId;
    private String name;
    private Double rating;
    private String skills;
}
