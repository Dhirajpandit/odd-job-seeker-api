package com.job.portals.RozgarBazar.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.MailException;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String senderEmail;  // Fetching sender email from application.properties

    public void sendEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(senderEmail); // sender email fetched from properties
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);

        try {
            mailSender.send(message);
        } catch (MailException e) {
            // Log error or send a failure notification (could also rethrow custom exception)
            System.err.println("Error sending email: " + e.getMessage());
        }
    }

    // PostConstruct is used to send a test email when application starts (for testing purposes)
    @PostConstruct
    public void testEmail() {
        sendEmail("+email", "Test Email", "Someone started our project.");
    }
}
