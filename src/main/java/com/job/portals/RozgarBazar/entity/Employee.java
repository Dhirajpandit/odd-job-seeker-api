package com.job.portals.RozgarBazar.entity;

import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employer_id")
    private Long id;
//    @Column(name = "job_title")
//    private String jobTitle;
//    @Column(name = "job_description")
//    private String jobDescription;

//    @Column(name = "full_name")
//    private String fullName;
//    @Column(name = "phone_number")
//    private String phoneNumber;
//    @Column(name = "email")
//    private String email;
//    @Column(name = "accountType")
//    private String accountType;
//    @Column(name = "location")
//    private String location;
//    @Column(name = "pay_rate")
//    private Double payRate;
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "shifttiming_id", referencedColumnName = "id")
//    private ShiftTimings shiftTimings;
//    @Column(name = "skills")
//    private List<String> skills;
//    @Column(name = "job_date")
//    private LocalDate jobDate;


}
