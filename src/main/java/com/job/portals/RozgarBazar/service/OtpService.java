package com.job.portals.RozgarBazar.service;

import com.job.portals.RozgarBazar.entity.OtpVerification;
import com.job.portals.RozgarBazar.repository.OtpVerificationRepository;
import com.job.portals.RozgarBazar.service.TwilioService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;
@Slf4j
@Service
public class OtpService {

    @Autowired
    private TwilioService twilioService;

    @Autowired
    private OtpVerificationRepository otpRepo;

    @Transactional  // <=== add here
    public void sendOtp(String phoneNumber) {
        String otp = String.format("%06d", new Random().nextInt(999999));

        OtpVerification otpEntity = new OtpVerification();
        otpEntity.setPhoneNumber(phoneNumber);
        otpEntity.setOtp(otp);
        otpEntity.setExpirationTime(LocalDateTime.now().plusMinutes(5));
        otpEntity.setVerified(false);
        log.info("deleting previous phone number entries for: " + phoneNumber);
        otpRepo.deleteByPhoneNumber(phoneNumber); // remove previous entries
        otpRepo.save(otpEntity);

        twilioService.sendOtp(phoneNumber, otp);
    }

    @Transactional
    public boolean verifyOtp(String phoneNumber, String otp) {
        Optional<OtpVerification> record = otpRepo.findByPhoneNumberAndOtp(phoneNumber, otp);
        if (record.isPresent() && record.get().getExpirationTime().isAfter(LocalDateTime.now())) {
            OtpVerification otpVerification = record.get();
            otpVerification.setVerified(true);
            otpRepo.save(otpVerification);
            return true;
        }
        return false;
    }
}
