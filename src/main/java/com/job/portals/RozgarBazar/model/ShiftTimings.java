package com.job.portals.RozgarBazar.model;

import com.job.portals.RozgarBazar.entity.Employee;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ShiftTimings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String startTime;
    private String endTime;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

}
