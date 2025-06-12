package com.job.portals.RozgarBazar.mapper;

import com.job.portals.RozgarBazar.dto.AddressDto;
import com.job.portals.RozgarBazar.dto.UserDto;
import com.job.portals.RozgarBazar.entity.Address;
import com.job.portals.RozgarBazar.entity.User;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface UserMapper {

 @Mapping(target = "profileCompletion", expression = "java(calculateProfileCompletion(user))")
    UserDto userToUserDto(User user);

    User userDtoToUser(UserDto userDto);

    AddressDto addressToAddressDto(Address address);
    Address addressDtoToAddress(AddressDto addressDto);

    default int calculateProfileCompletion (User user){
        int total = 7;
        int filled = 0;

        if (user.getEmail()!= null && !user.getEmail().isEmpty()) filled++;

        if (user.getName()!= null && !user.getName().isEmpty()) filled++;

        if (user.getAccountType() != null) filled++;

        if (user.getPhoneNumber() != null && !user.getPhoneNumber().isEmpty()) filled++;

        if (user.getCompanyName() != null && !user.getCompanyName().isEmpty()) filled++;

        if (user.getIndustry() != null && !user.getIndustry().isEmpty()) filled++;

        if (user.getAddress() != null) filled++;

        return (filled * 100) / total;



    }


}
