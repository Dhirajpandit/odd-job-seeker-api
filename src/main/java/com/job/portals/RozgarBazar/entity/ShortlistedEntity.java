package com.job.portals.RozgarBazar.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class ShortlistedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long employerId;
    private Long jobId;
    private Long workerId;
}
