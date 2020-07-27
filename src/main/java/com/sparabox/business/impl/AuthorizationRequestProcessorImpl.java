package com.sparabox.business.impl;

import com.sparabox.business.AuthorizationRequestProcessor;
import com.sparabox.business.utility.BuilderUtility;
import com.sparabox.domain.business.AuthorizationRequestDto;
import com.sparabox.domain.business.CardDto;
import com.sparabox.domain.business.MerchantDto;
import com.sparabox.domain.persistence.Account;
import com.sparabox.domain.persistence.Card;
import com.sparabox.domain.persistence.Merchant;
import com.sparabox.domain.persistence.Transaction;
import com.sparabox.repository.AccountRepository;
import com.sparabox.repository.CardRepository;
import com.sparabox.repository.MerchantRepository;
import com.sparabox.repository.TransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by rendani.dau on 2020/04/24.
 */
@Service
public class AuthorizationRequestProcessorImpl implements AuthorizationRequestProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthorizationRequestProcessorImpl.class);

    private final TransactionRepository transactionRepository;
    private final CardRepository cardRepository;
    private final AccountRepository accountRepository;
    private final MerchantRepository merchantRepository;

    @Autowired
    public AuthorizationRequestProcessorImpl(TransactionRepository transactionRepository, CardRepository cardRepository, AccountRepository accountRepository, MerchantRepository merchantRepository) {
        this.transactionRepository = transactionRepository;
        this.cardRepository = cardRepository;
        this.accountRepository = accountRepository;
        this.merchantRepository = merchantRepository;
    }

    @Override
    public void processTransaction(AuthorizationRequestDto authorizationRequestDto) {
        LOGGER.info("::processTransaction() - START");
        Transaction transaction = buildTransaction(authorizationRequestDto);
        transactionRepository.save(transaction);
        LOGGER.info("::processTransaction() - END");
    }

    private Transaction buildTransaction(AuthorizationRequestDto authorizationRequestDto) {
        Card card = getOrCreateCard(authorizationRequestDto.getCardDto());
        Account account = getOrCreateAccount(authorizationRequestDto.getAccountNumber());
        Merchant merchant = getOrCreateMerchant(authorizationRequestDto.getMerchantDto());
        return BuilderUtility.buildTransaction(authorizationRequestDto, card, account, merchant);
    }

    private Merchant getOrCreateMerchant(MerchantDto merchantDto) {
        Merchant merchant = merchantRepository.findByNameAndCity(merchantDto.getName(), merchantDto.getCity());
        if (null == merchant) {
            merchant = merchantRepository.save(BuilderUtility.buildMerchant(merchantDto));
        }
        return merchant;
    }

    private Account getOrCreateAccount(String accountNumber) {
        Account account = accountRepository.findByAccountNumber(Long.valueOf(accountNumber));
        if (null == account) {
            account = accountRepository.save(new Account(Long.valueOf(accountNumber)));
        }
        return account;
    }

    private Card getOrCreateCard(CardDto cardDto) {
        Card card = cardRepository.findByCardNumber(cardDto.getId());
        if (null == card) {
            card = cardRepository.save(new Card(cardDto.getId()));
        }
        return card;
    }

}
