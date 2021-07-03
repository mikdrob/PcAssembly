package com.example.demo.smtp;


import com.example.demo.dto.EmailTemplate;
import com.example.demo.dto.EmailItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("EmailService")
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private EmailTemplate emailTemplate;


    @Override
    public void sendOrderConfirmationMessage(String to, List<EmailItems> items) {
        SimpleMailMessage msg = new SimpleMailMessage();
        String message = emailTemplate.getText();
        for (EmailItems item:items) {
            message+=item.getTitle() + ": "+ item.getPrice() + "\n";
        }

        msg.setTo(to);

        msg.setSubject(emailTemplate.getSubject());
        msg.setText(message);

        javaMailSender.send(msg);
    }

}
