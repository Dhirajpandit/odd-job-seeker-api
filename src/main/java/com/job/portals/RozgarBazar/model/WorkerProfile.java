package com.job.portals.RozgarBazar.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class WorkerProfile {

    private Long WorkerId;
    private String name;
    private Double rating;
    private String skills;
    private String location;

}

