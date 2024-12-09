package com.job.portals.RozgarBazar.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class WorkerProfile {

    private Long id;
    private String name;
    private String mobileNumber;
    private List<String> skills;
    private Boolean availability;
    private String address;
    private List<Experience> experience;

}

