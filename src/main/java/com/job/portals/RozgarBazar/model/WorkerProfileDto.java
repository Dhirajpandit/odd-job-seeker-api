package com.job.portals.RozgarBazar.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkerProfileDto {
    @NotBlank(message = "WorkerId is mandatory")
    private Long WorkerId;
    @NotBlank(message = "Name is mandatory")
    private String name;
    private Double rating;
    private Set<String> skills = new HashSet<>();

}
