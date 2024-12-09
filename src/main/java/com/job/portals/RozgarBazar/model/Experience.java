package com.job.portals.RozgarBazar.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Experience {

    private String organizationName;
    private String startDate;
    private String endDate;
    private String address;
    private String pinCode;

}
