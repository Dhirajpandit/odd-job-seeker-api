package com.job.portals.RozgarBazar.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;


import java.util.Date;

@Entity
@Table(name = "hiring_records")
@Data
public class HiringWorker{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "Employer_id", referencedColumnName = "employer_id")
//    private Long employerId;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "Worker_id", referencedColumnName = "id")
//    private Worker workerId;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "job_id", referencedColumnName = "id")
//    private Job jobId;

    private Date hireDate;
    
}