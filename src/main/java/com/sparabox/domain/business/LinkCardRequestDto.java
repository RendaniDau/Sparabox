package com.sparabox.domain.business;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

public class LinkCardRequestDto implements Serializable {
    private static final long serialVersionUID = -5441860166670044581L;
    private Long accountNumber;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String cardNumber;

    public LinkCardRequestDto() {
    }

    public LinkCardRequestDto(Long accountNumber, String cardNumber) {
        this.accountNumber = accountNumber;
        this.cardNumber = cardNumber;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
