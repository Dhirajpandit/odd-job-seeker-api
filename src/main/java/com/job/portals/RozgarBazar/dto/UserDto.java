package com.job.portals.RozgarBazar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private String email;
    private String name;
    private String accountType;
    private String phoneNumber;
    private String companyName;
    private String industry;
    private AddressDto address;
}
