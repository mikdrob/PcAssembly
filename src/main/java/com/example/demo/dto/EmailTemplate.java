package com.example.demo.dto;

public class EmailTemplate {
    String subject;
    String text;
    String attachmentUrl;

    public EmailTemplate(String subject, String text, String attachmentUrl) {
        this.subject = subject;
        this.text = text;
        this.attachmentUrl = attachmentUrl;
    }

    public EmailTemplate(String subject, String text) {
        this.subject = subject;
        this.text = text;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAttachmentUrl() {
        return attachmentUrl;
    }

    public void setAttachmentUrl(String attachmentUrl) {
        this.attachmentUrl = attachmentUrl;
    }
}
