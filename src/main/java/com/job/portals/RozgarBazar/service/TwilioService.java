package com.job.portals.RozgarBazar.service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TwilioService {

 @Value("${twilio.accountSid}")
 private String accountSid;

 @Value("${twilio.authToken}")
 private String authToken;

 @Value("${twilio.phoneNumber}")
 private String fromNumber;

 @PostConstruct
 public void init() {
  Twilio.init(accountSid, authToken);
  System.out.println("Twilio initialized with SID: " + accountSid);
 }

 public void sendOtp(String toPhoneNumber, String otp) {
  Message.creator(
          new PhoneNumber(toPhoneNumber),
          new PhoneNumber(fromNumber),
          "Your OTP is: " + otp
  ).create();
 }
}
