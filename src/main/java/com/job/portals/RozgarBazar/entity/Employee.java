package com.job.portals.RozgarBazar.entity;

import com.job.portals.RozgarBazar.model.ShiftTimings;
import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employerId;
    private String jobTitle;
    private String jobDescription;
    private String location;
    private Double payRate;
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<ShiftTimings> shiftTimings;
    private List<String> skillsRequired;
    private LocalDate jobDate;


}
