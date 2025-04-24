package com.job.portals.RozgarBazar.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class WorkerProfile {

    private Long WorkerId;
    private String name;
    private Double rating;
    private Set<String> skills = new HashSet<>();
    private String location;

}

