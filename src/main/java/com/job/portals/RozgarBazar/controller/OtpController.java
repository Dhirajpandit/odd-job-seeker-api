package com.job.portals.RozgarBazar.controller;

import com.job.portals.RozgarBazar.service.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/otp")
public class OtpController {

    @Autowired
    private OtpService otpService;

    @PostMapping("/send")
    public ResponseEntity<String> sendOtp(@RequestParam String phoneNumber) {
        otpService.sendOtp(phoneNumber);
        return ResponseEntity.ok("OTP sent to " + phoneNumber);
    }

    @PostMapping("/verify")
    public ResponseEntity<String> verifyOtp(@RequestParam String phoneNumber, @RequestParam String otp) {
        boolean verified = otpService.verifyOtp(phoneNumber, otp);
        return verified ? ResponseEntity.ok("OTP verified successfully")
                : ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid or expired OTP");
    }
}
