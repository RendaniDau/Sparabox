package com.sparabox.business.utility;

import com.sparabox.domain.business.AuthorizationRequestDto;
import com.sparabox.domain.business.CardDto;
import com.sparabox.domain.business.MerchantDto;
import com.sparabox.domain.persistence.Account;
import com.sparabox.domain.persistence.Card;
import com.sparabox.domain.persistence.Merchant;
import com.sparabox.domain.persistence.Transaction;

import java.time.LocalDateTime;

public class BuilderUtility {

    public static Transaction buildTransaction(AuthorizationRequestDto authorizationRequestDto, Card card, Account account, Merchant merchant) {
        Transaction transaction = new Transaction();
        transaction.setAmount(authorizationRequestDto.getCentsAmount());
        transaction.setType(authorizationRequestDto.getType());
        transaction.setCurrencyCode(authorizationRequestDto.getCurrencyCode());
        transaction.setTransactionDateTime(authorizationRequestDto.getDateTime());
        transaction.setCard(card);
        transaction.setAccount(account);
        transaction.setMerchant(merchant);

        return transaction;
    }

    public static Card buildCard(CardDto cardDto) {
        Card card = new Card();
        card.setCardNumber(cardDto.getId());

        return card;
    }

    public static Merchant buildMerchant(MerchantDto merchantDto) {
        Merchant merchant = new Merchant();
        merchant.setName(merchantDto.getName());
        merchant.setCity(merchantDto.getCity());
        merchant.setCategoryCode(merchantDto.getCategoryDto().getCode());
        merchant.setCategoryKey(merchantDto.getCategoryDto().getKey());
        merchant.setCategoryName(merchantDto.getCategoryDto().getName());
        merchant.setCountryAphaThree(merchantDto.getCountryDto().getAlpha3());
        merchant.setCountryCode(merchantDto.getCountryDto().getCode());
        merchant.setCountryName(merchantDto.getCountryDto().getName());

        return merchant;
    }
}
