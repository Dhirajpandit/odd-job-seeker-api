package com.job.portals.RozgarBazar.entity;

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

    @OneToOne(mappedBy = "shiftTimings")
    private Employee employee;

}
