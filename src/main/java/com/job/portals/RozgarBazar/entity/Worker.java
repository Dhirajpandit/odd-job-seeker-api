package com.job.portals.RozgarBazar.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long workerId;
    @Column(name = "name")
    private String name;
    @Column(name = "rating")
    private Double rating;
    @Column(name = "skills")
    private String skills;
    @Column(name = "location")
    private String location;
}
