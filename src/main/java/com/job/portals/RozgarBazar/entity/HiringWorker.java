package com.job.portals.RozgarBazar.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.batch.BatchProperties;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class HiringWorker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long employerId;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private BatchProperties.Job job;

    @ManyToOne
    @JoinColumn(name = "worker_id")
    private Worker worker;

    private LocalDateTime hireDate;
    private Boolean active;
}
