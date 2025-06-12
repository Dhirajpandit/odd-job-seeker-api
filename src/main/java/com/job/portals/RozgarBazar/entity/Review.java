package com.job.portals.RozgarBazar.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
@Column(name = "job_portal_name")
    private String jobPortalName;
    private String reviewer;
    private int rating;
    private String comments;
}
