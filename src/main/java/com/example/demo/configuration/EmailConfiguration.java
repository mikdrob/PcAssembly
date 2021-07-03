package com.example.demo.configuration;

import com.example.demo.dto.EmailTemplate;
import com.example.demo.smtp.EmailServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class EmailConfiguration {

    @Bean
    public EmailTemplate templateSimpleMessage() {
        String subject = "Order Confirmation";
        String text = "Thank you for your order!\n";
        EmailTemplate template = new EmailTemplate(subject, text);
        return template;
    }


}
