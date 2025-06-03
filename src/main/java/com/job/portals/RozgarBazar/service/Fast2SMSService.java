package com.job.portals.RozgarBazar.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class Fast2SMSService {

 @Value("${fast2sms.api.url}")
 private String fast2smsUrl;

 @Value("${fast2sms.api.key}")
 private String fast2smsApiKey;

 private final RestTemplate restTemplate = new RestTemplate();

 @PostConstruct
 public void init() {
  System.out.println("Fast2SMS initialized with API Key: " + fast2smsApiKey);
 }

 public void sendOtp(String toPhoneNumber, String otp) {
  try {
   // Prepare JSON body
   Map<String, Object> body = new HashMap<>();
   body.put("route", "q");
   body.put("variables_values", otp);
body.put("message", "Your OTP is: " + otp);
   body.put("numbers", toPhoneNumber); // E.g., "9172470598"

   // Prepare headers
   HttpHeaders headers = new HttpHeaders();
   headers.setContentType(MediaType.APPLICATION_JSON); // Required header
   headers.set("authorization", fast2smsApiKey);        // Required header

   // Create request
   HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);

   // Send POST request
   ResponseEntity<String> response = restTemplate.postForEntity(fast2smsUrl, request, String.class);

   System.out.println("Fast2SMS Response: " + response.getBody());

  } catch (HttpClientErrorException ex) {
   String responseBody = ex.getResponseBodyAsString();
   System.err.println("Failed to send OTP via Fast2SMS: " + responseBody);
   throw new RuntimeException(responseBody); // this will trigger 500 Internal Server Error in controller
  } catch (Exception e) {
   throw new RuntimeException("Unknown error while sending OTP: " + e.getMessage());
  }
 }
}


//package com.job.portals.RozgarBazar.service;
//
//import jakarta.annotation.PostConstruct;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.*;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.HttpClientErrorException;
//import org.springframework.web.client.RestTemplate;
//
//@Service
//public class Fast2SMSService {
//
// @Value("${fast2sms.api.url}")
// private String fast2smsUrl;
//
// @Value("${fast2sms.api.key}")
// private String fast2smsApiKey;
//
// private final RestTemplate restTemplate = new RestTemplate();
//
// @PostConstruct
// public void init() {
//  System.out.println("Fast2SMS initialized with API Key: " + fast2smsApiKey);
// }
//
// public void sendOtp(String toPhoneNumber, String otp) {
//  try {
//   String message = "Your OTP is: " + otp;
//
//   HttpHeaders headers = new HttpHeaders();
//   headers.setContentType(MediaType.APPLICATION_JSON);
//   headers.set("authorization", fast2smsApiKey);
//
//   String jsonBody = String.format(
//           "{\"route\":\"q\",\"message\":\"%s\",\"language\":\"english\",\"numbers\":\"%s\"}",
//           message, formatPhoneNumber(toPhoneNumber)
//   );
//
//   HttpEntity<String> request = new HttpEntity<>(jsonBody, headers);
//
//   ResponseEntity<String> response = restTemplate.postForEntity(
//           fast2smsUrl, request, String.class
//   );
//
//   System.out.println("Fast2SMS Response: " + response.getBody());
//
//  } catch (HttpClientErrorException ex) {
//   String responseBody = ex.getResponseBodyAsString();
//   System.err.println("Failed to send OTP via Fast2SMS: " + responseBody);
//   throw new RuntimeException(responseBody);
//  } catch (Exception e) {
//   throw new RuntimeException("Unknown error while sending OTP: " + e.getMessage());
//  }
// }
//
// private String formatPhoneNumber(String phoneNumber) {
//  return phoneNumber.startsWith("91") ? phoneNumber : "91" + phoneNumber;
// }
//}
