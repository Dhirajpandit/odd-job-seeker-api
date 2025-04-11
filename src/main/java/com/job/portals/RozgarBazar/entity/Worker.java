package com.job.portals.RozgarBazar.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
public class Worker {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private Long WorkerId;
    @Column(name = "name")
    private String name;
    @Column(name = "rating")
    private Double rating;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "worker_skills", joinColumns = @JoinColumn(name = "worker_id"))
    @Column(name = "skills")
    private String skills;
    @Column(name = "location")
    private String location;
}
