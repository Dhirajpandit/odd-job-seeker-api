package com.job.portals.RozgarBazar.model;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkerProfileDto {
    private Long WorkerId;
    private String name;
    private Double rating;
    private String skills;

}
