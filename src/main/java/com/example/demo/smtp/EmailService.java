package com.example.demo.smtp;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.Map;

public interface EmailService {
    void sendOrderConfirmationMessage(String to);

}
