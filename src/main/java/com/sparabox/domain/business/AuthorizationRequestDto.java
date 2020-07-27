package com.sparabox.domain.business;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by rendani.dau on 2020/04/24.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthorizationRequestDto implements Serializable {

    private String accountNumber;
    private LocalDateTime dateTime;
    private Long centsAmount;
    private String currencyCode;
    private String type;
    private String reference;
    @JsonProperty("card")
    private CardDto cardDto;
    @JsonProperty("merchant")
    private MerchantDto merchantDto;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Long getCentsAmount() {
        return centsAmount;
    }

    public void setCentsAmount(Long centsAmount) {
        this.centsAmount = centsAmount;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public CardDto getCardDto() {
        return cardDto;
    }

    public void setCardDto(CardDto cardDto) {
        this.cardDto = cardDto;
    }

    public MerchantDto getMerchantDto() {
        return merchantDto;
    }

    public void setMerchantDto(MerchantDto merchantDto) {
        this.merchantDto = merchantDto;
    }

}
