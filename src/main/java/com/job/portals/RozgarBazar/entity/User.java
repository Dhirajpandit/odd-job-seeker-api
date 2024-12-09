package com.job.portals.RozgarBazar.entity;

import com.job.portals.RozgarBazar.enums.AccountType;
import com.job.portals.RozgarBazar.enums.OnboardingStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "users"
        /*indexes = {
                @Index(name = "idx_users_email", columnList = "email"),
                @Index(name = "idx_users_role", columnList = "role")
        }*/)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = true)
    private String password;

    @Column(nullable = true)
    private String name;

    @Column(nullable = true)
    @Enumerated(EnumType.STRING) // Store as ENUM string
    private AccountType accountType; // EMPLOYER or JOB_SEEKER

    @Column(nullable = true,unique = true) // Optional
    private String phoneNumber;

    @Column(nullable = true)
    private String companyName; // Relevant for employers

    @Column(nullable = true)
    private String industry;

    @Column(name = "is_active", nullable = true)
    private Boolean isActive = true;

    @Column(name = "is_verified", nullable = true)
    private Boolean isVerified = false;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @Column(nullable = true)
    @Enumerated(EnumType.STRING)
    private OnboardingStatus onboardingStatus;
}
