package com.job.portals.RozgarBazar.service;

import com.job.portals.RozgarBazar.dto.UserDto;
import com.job.portals.RozgarBazar.entity.User;
import com.job.portals.RozgarBazar.mapper.UserMapper;
import com.job.portals.RozgarBazar.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class UserService {


    private final UserRepository userRepository;


    private final UserMapper userMapper;



    public User createUser(UserDto user) {
        log.info(":::: Created User Method Start ::::");
        if (userRepository.existsByPhoneNumber(user.getPhoneNumber())) {
            log.warn(user.getPhoneNumber()+ " Mobile Number is already exists :::");
            throw new IllegalArgumentException("Mobile Number is already exists, Please login !");
        }
        User userEntity = userMapper.userDtoToUser(user);
        log.info("::: Creating User :::");
        return userRepository.save(userEntity);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + id));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User updateUser(Long id, UserDto updatedUser) {
        User existingUser = getUserById(id);
        /*existingUser.setFirstName(updatedUser.getFirstName());
        existingUser.setLastName(updatedUser.getLastName());
        existingUser.setPhoneNumber(updatedUser.getPhoneNumber());
        existingUser.setProfilePictureUrl(updatedUser.getProfilePictureUrl());
        existingUser.setRole(updatedUser.getRole());
        existingUser.setIsActive(updatedUser.getIsActive());
        existingUser.setIsVerified(updatedUser.getIsVerified());*/
        return userRepository.save(existingUser);
    }

    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new IllegalArgumentException("User not found with ID: " + id);
        }
        userRepository.deleteById(id);
    }

    public Optional<User> findByPhoneNumber(String phoneNumber) {
        return userRepository.findByPhoneNumber(phoneNumber);
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
