package com.sparabox.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CARD", schema = "SPA_BOX")
public class Card implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SPA_BOX_SEQ")
    @SequenceGenerator(name = "SPA_BOX_SEQ", sequenceName = "SEQUENCE_SPA_BOX")
    @Column(name = "CARD_ID")
    private Long cardId;

    @Column(name = "CARD_NUMBER", nullable = false, unique = true)
    private String cardNumber;

    public Card() {
    }

    public Card(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
