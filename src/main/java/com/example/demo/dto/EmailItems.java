package com.example.demo.dto;

import org.hibernate.annotations.Type;

public class EmailItems {
    @Type(type = "org.hibernate.type.StringType")
    private String title;

    private Integer price;

    private String pictureUrl;

    private String emailAddress;


    public EmailItems(String title, Integer price, String pictureUrl, String emailAddress) {
        this.title = title;
        this.price = price;
        this.pictureUrl = pictureUrl;
        this.emailAddress = emailAddress;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
