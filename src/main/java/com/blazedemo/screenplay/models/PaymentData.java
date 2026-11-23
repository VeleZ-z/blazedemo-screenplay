package com.blazedemo.screenplay.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentData {
    private String name;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String cardType;
    private String creditCardNumber;
    private String creditCardMonth;
    private String creditCardYear;
    private String nameOnCard;
    private boolean rememberMe;

    public static PaymentData valid() {
        return PaymentData.builder()
                .name("John Doe")
                .address("123 Main St")
                .city("Anytown")
                .state("CA")
                .zipCode("12345")
                .cardType("Visa")
                .creditCardNumber("4111111111111111")
                .creditCardMonth("12")
                .creditCardYear("2025")
                .nameOnCard("John Doe")
                .rememberMe(true)
                .build();
    }

    public static PaymentData empty() {
        return PaymentData.builder()
                .name("")
                .address("")
                .city("")
                .state("")
                .zipCode("")
                .cardType("Visa")
                .creditCardNumber("")
                .creditCardMonth("")
                .creditCardYear("")
                .nameOnCard("")
                .rememberMe(false)
                .build();
    }

    public static PaymentData invalidCard() {
        return PaymentData.builder()
                .name("John Doe")
                .address("123 Main St")
                .city("Anytown")
                .state("CA")
                .zipCode("12345")
                .cardType("Visa")
                .creditCardNumber("1234567890")
                .creditCardMonth("12")
                .creditCardYear("2025")
                .nameOnCard("John Doe")
                .rememberMe(false)
                .build();
    }
}