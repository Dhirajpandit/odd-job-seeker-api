package com.job.portals.RozgarBazar.dto;

import lombok.Data;

// HiringResponse.java
@Data
public class HiringDto {
    private String status;
    private Long hireId;
    private String workerName;
    private String jobTitle;
    private String hireDate;
}