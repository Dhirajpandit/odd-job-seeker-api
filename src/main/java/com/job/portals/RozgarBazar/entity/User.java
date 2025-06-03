package com.job.portals.RozgarBazar.entity;

import com.job.portals.RozgarBazar.enums.AccountType;
import com.job.portals.RozgarBazar.enums.OnboardingStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.time.LocalDateTime;
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

    @Column (nullable = true)
    private String email;

    @Column(nullable = true)
    private String password;

    @Column(nullable = true)
    private String name;

    @Column(nullable = true)
    @Enumerated(EnumType.STRING) // Store as ENUM string
    private AccountType accountType; // EMPLOYER or JOB_SEEKER

    @Column(nullable = false,unique = true) // Optional
    private String phoneNumber;
    private LocalDateTime createdAt;

    @Column(nullable = true)
    private String companyName; // Relevant for employers

    @Column(nullable = true)
    private String industry;

    @Column(name = "is_active", nullable = true)
    private Boolean isActive = true;

    public Boolean getMobileVerified() {
        return mobileVerified;
    }

    public void setMobileVerified(Boolean mobileVerified) {
        this.mobileVerified = mobileVerified;
    }

    @Column(name = "mobile_Verified", nullable = true)
    private Boolean mobileVerified = false;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @Column(nullable = true)
    @Enumerated(EnumType.STRING)
    private OnboardingStatus onboardingStatus;

}
