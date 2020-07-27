package com.sparabox.domain.business;

import com.sparabox.domain.persistence.Transaction;

import java.io.Serializable;
import java.time.LocalDateTime;

public class TransactionDto implements Serializable {
    private static final long serialVersionUID = -4751249714059950380L;

    private Long transactionId;
    private String card;
    private Long amount;
    private String currencyCode;
    private String merchantName;
    private LocalDateTime transactionDateTime;

    public TransactionDto() {
    }

    public TransactionDto(Transaction transaction) {
        this.transactionId = transaction.getTransactionId();
        this.card = transaction.getCard().getCardNumber();
        this.amount = transaction.getAmount();
        this.currencyCode = transaction.getCurrencyCode();
        this.merchantName = transaction.getMerchant().getName();
        this.transactionDateTime = transaction.getTransactionDateTime();
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public LocalDateTime getTransactionDateTime() {
        return transactionDateTime;
    }

    public void setTransactionDateTime(LocalDateTime transactionDateTime) {
        this.transactionDateTime = transactionDateTime;
    }
}
