package com.job.portals.RozgarBazar.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "jobs")
@Data
public class Job {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String jobId;

    @Column(nullable = false)
    private String jobTitle;
    private String jobDescription;
    private String employerId; // Detailed requirements
    private String location;        // Job location
    private double payRate;// Hourly rate

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shifttiming_id", referencedColumnName = "id")
    private ShiftTimings shiftTimings; // Work hours
    private Set<String> skillsRequired; // Needed skills
    private LocalDate jobDate;  //date
 }
