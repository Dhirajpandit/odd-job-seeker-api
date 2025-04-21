package com.job.portals.RozgarBazar.model;

import com.job.portals.RozgarBazar.entity.ShiftTimings;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeProfileDto {
    private String employerId;
    private String jobId;
    private String jobTitle;
    private String jobDescription;
    private String location;
    private Double payRate;
    private ShiftTimings shiftTimings;
    private List<String> skillsRequired;
    private LocalDate jobDate;
}
