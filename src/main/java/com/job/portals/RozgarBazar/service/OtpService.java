package com.job.portals.RozgarBazar.service;

import com.job.portals.RozgarBazar.config.JwtUtil;
import com.job.portals.RozgarBazar.entity.OtpVerification;
import com.job.portals.RozgarBazar.entity.User;
import com.job.portals.RozgarBazar.repository.OtpVerificationRepository;
import com.job.portals.RozgarBazar.repository.UserRepository;
import com.job.portals.RozgarBazar.service.Fast2SMSService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;


@Slf4j
@Service
public class OtpService {

    @Autowired
    private Fast2SMSService Fast2SMSService;

    @Autowired
    private OtpVerificationRepository otpRepo;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

private final int OTP_EXPIRY_IN_MINUTES = 5;

    @Transactional  // <=== add here
    public void sendOtp(String phoneNumber) {
//        String formattedPhone = phoneNumber.startsWith("+91") ? phoneNumber : "+91" + phoneNumber;
        String otp = String.format("%06d", new Random().nextInt(999999));

        OtpVerification otpEntity = new OtpVerification();
        otpEntity.setPhoneNumber(phoneNumber);
        otpEntity.setOtp(otp);
        otpEntity.setExpirationTime(LocalDateTime.now().plusMinutes(5));
        otpEntity.setVerified(false);
        log.info("Deleting previous phone number entries for: " + phoneNumber);
        otpRepo.deleteByPhoneNumber(phoneNumber); // remove previous entries
        otpRepo.save(otpEntity);


            try {
                Fast2SMSService.sendOtp(phoneNumber, otp);
            } catch (Exception e) {
                // Simply rethrow the exception
                throw new RuntimeException("Error(Failed to send OTP via Fast2SMS)", e);
            }



    }

    @Transactional
    public Optional<String> verifyOtpAndGenerateToken(String phoneNumber, String otp) {
        log.info("Inside the verify Otp Generator Token Method:::");
        Optional<OtpVerification> record = otpRepo.findByPhoneNumberAndOtp(phoneNumber, otp);

        if (record.isPresent() && record.get().getExpirationTime().isAfter(LocalDateTime.now())) {
            OtpVerification otpVerification = record.get();
            otpVerification.setVerified(true);
            otpRepo.save(otpVerification);

            // Get or create user
            User user = userRepository.findByPhoneNumber(phoneNumber)
                    .orElseGet(() -> {
                        User User = new User();
                        User.setPhoneNumber(phoneNumber);
                        User.setCreatedAt(LocalDateTime.now());
                        return userRepository.save(User);
                    });
            String token = jwtUtil.generateToken(user.getPhoneNumber());
            log.info("JWT Token Generated For User {}:{}",phoneNumber, token);
            return Optional.of(token);
        }
        return Optional.empty();
    }
    public  boolean isUserExists(String phoneNumber){
        return userRepository.findByPhoneNumber(phoneNumber).isPresent();
    }

}