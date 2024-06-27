package com.example.myticketsystem.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Data
@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public String sendEmail(String to,String cc, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        try {
            message.setTo(to);
            message.setCc(cc);
            message.setSubject(subject);
            message.setText(text);
            javaMailSender.send(message);
            return "Mail envoyé";
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e) ;
        }
    }
}
