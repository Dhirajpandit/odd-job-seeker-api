package com.job.portals.RozgarBazar.controller;

import com.job.portals.RozgarBazar.config.JwtUtil;

import com.job.portals.RozgarBazar.service.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/api/otp")
public class OtpController {

    @Autowired
    private OtpService otpService;

    @Autowired
    private JwtUtil jwtUtil;

//send otp endpoint
    @PostMapping("/send")
    public ResponseEntity<String> sendOtp(@RequestParam ("phoneNumber") String phoneNumber) {
        boolean isExisting = otpService.isUserExists(phoneNumber);
        otpService.sendOtp(phoneNumber);
        return ResponseEntity.ok("OTP sent to " + phoneNumber + " (" + (isExisting ? "login" : "signup") + ")");
    }

    // Verify OTP endpoint, returns JWT + user on success
    @PostMapping("/verify")
    public ResponseEntity<?> verifyOtp(@RequestParam String phoneNumber, @RequestParam("otp") String otp) {
        return otpService.verifyOtpAndGenerateToken(phoneNumber, otp)
                .map(token -> ResponseEntity.ok(Map.of(
                        "message", "OTP verified successfully",
                        "token", token
                )))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", "Invalid or expired OTP")));
    }

//
//        User user = OtpService.getOrCreateUser(phoneNumber);
//        String token = jwtUtil.generateToken(phoneNumber);
//
//        return ResponseEntity.ok(Map.of(
//                "message", "OTP verified successfully",
//                "token", token,
//                "user", user
//        ));
//    }
}






//
//    @PostMapping("/verify")
//    public ResponseEntity<?> verifyOtp(@RequestParam String phoneNumber, @RequestParam String otp) {
//        if (!otpService.verifyOtp(phoneNumber, otp)) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid or expired OTP");
//        }
//
//        User user = otpService.getOrCreateUser(phoneNumber); // New method
//        JwtUtil jwtUtil;
//        String token = jwtUtil.generateToken(phoneNumber);
//
//        return ResponseEntity.ok(Map.of(
//                "message", "OTP verified successfully",
//                "token", token,
//                "user", user
//        ));
//    }
//
//
//
//
//}
