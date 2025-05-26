package com.job.portals.RozgarBazar.dto;

import lombok.Data;

import java.util.Set;

@Data
public class WorkerProfileDto {
    private String name;
    private String email;
    private Set<String> skills;
    private String location;
}
