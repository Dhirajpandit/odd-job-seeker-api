package com.job.portals.RozgarBazar.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkerProfileDto {
    private String name;
    private String mobileNumber;
    private List<String> skills;
    private Boolean availability;
    private String address;
    private List<Experience> experience;


}
