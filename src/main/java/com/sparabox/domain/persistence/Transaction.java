package com.sparabox.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by rendani.dau on 2020/04/24.
 */
@Entity
@Table(name = "CARD_TRANSACTION", schema = "SPA_BOX")
public class Transaction implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SPA_BOX_SEQ")
    @SequenceGenerator(name = "SPA_BOX_SEQ", sequenceName = "SEQUENCE_SPA_BOX")
    @Column(name = "TRANSACTION_ID")
    private Long transactionId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ACCOUNT_NUMBER", nullable = false)
    private Account account;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CARD_NUMBER", nullable = false)
    private Card card;

    @Column(name = "AMOUNT", nullable = false)
    private Long amount;

    @Column(name = "CURRENCY_CODE", nullable = false)
    private String currencyCode;

    @Column(name = "TYPE", nullable = false)
    private String type;

    @Column(name = "TRX_DATE_TIME", columnDefinition = "TIMEST AMP", nullable = false)
    private LocalDateTime transactionDateTime;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MERCHANT_ID", nullable = false)
    private Merchant merchant;

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getTransactionDateTime() {
        return transactionDateTime;
    }

    public void setTransactionDateTime(LocalDateTime transactionDateTime) {
        this.transactionDateTime = transactionDateTime;
    }

    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }
}
