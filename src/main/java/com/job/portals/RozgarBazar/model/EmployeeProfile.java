package com.job.portals.RozgarBazar.model;

import com.job.portals.RozgarBazar.entity.Address;
import com.job.portals.RozgarBazar.entity.ShiftTimings;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeProfile {
    private String employerId;
//    private String jobTitle;
//    private String jobDescription;
    private String fullName;
    private String phoneNumber;
    private String email;
    private String accountType;
    private String location;
    private Double payRate;
    private ShiftTimings shiftTimings;
    private List<String> skills;
//    private LocalDate jobDate;
    private Address address;
}
