package com.job.portals.RozgarBazar.mapper;

import com.job.portals.RozgarBazar.dto.AddressDto;
import com.job.portals.RozgarBazar.dto.UserDto;
import com.job.portals.RozgarBazar.entity.Address;
import com.job.portals.RozgarBazar.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto userToUserDto(User user);
    User userDtoToUser(UserDto userDto);
    AddressDto addressToAddressDto(Address address);
    Address addressDtoToAddress(AddressDto addressDto);
}
