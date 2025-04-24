package com.job.portals.RozgarBazar.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private Long WorkerId;
    @Column(name = "name")
    private String name;
    @Column(name = "rating")
    private Double rating;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "worker_skills", joinColumns = @JoinColumn(name = "worker_id"))
    @Column(name = "skills")
    private Set<String> skills = new HashSet<>();
    @Column(name = "location")
    private String location;
}
