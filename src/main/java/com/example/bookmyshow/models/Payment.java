package com.example.bookmyshow.models;

public class Payment extends BaseModel{
    private String referenceNumber;
    private int amount;

    private PaymentProvider paymentProvider;
    private PaymentMode paymentMode;
    private PaymentStatus paymentStatus;
}
