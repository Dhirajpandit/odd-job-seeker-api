package com.job.portals.RozgarBazar.repository;

import com.job.portals.RozgarBazar.entity.OtpVerification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OtpVerificationRepository extends JpaRepository<OtpVerification, Long> {
    Optional<OtpVerification> findByPhoneNumberAndOtp(String phoneNumber, String otp);
    void deleteByPhoneNumber(String phoneNumber);
}
