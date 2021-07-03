package com.example.demo.smtp;


import com.example.demo.dto.EmailTemplate;
import com.example.demo.model.Cart;
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
    public void sendOrderConfirmationMessage(String to, List<Cart> items) {
        SimpleMailMessage msg = new SimpleMailMessage();
        StringBuilder message = new StringBuilder(emailTemplate.getText());
        for (Cart item:items) {
            message.append(item.getItem().getTitle()).append(": ").append(item.getItem().getPrice()).append("euro").append("\n");
        }

        msg.setTo(to);

        msg.setSubject(emailTemplate.getSubject());
        msg.setText(message.toString());

        javaMailSender.send(msg);
    }

}
