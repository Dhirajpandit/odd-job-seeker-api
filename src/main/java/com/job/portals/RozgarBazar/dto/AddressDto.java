package com.job.portals.RozgarBazar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String pinCode;
}
