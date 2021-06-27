package com.example.demo.configuration;

import com.example.demo.smtp.EmailServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;

@Configuration
public class EmailConfiguration {
    @Bean
    public EmailServiceImpl getJavaMailSender() {


        return new EmailServiceImpl();
    }
}
