package com.job.portals.RozgarBazar.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "jobs")
@Data
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jobId;

    @Column(nullable = false)
    private String jobTitle;
    private String jobDescription;
    private String employerId; // Detailed requirements
    private String location;        // Job location
    private double payRate;         // Hourly rate
    private ShiftTimings shiftTimings; // Work hours
    private List<String> skillsRequired; // Needed skills
    private String jobDate;

}