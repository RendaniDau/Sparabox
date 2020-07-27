package com.sparabox.business.impl;

import com.sparabox.business.AccountFlow;
import com.sparabox.domain.exception.SparaBoxException;
import com.sparabox.domain.persistence.Account;
import com.sparabox.domain.persistence.Transaction;
import com.sparabox.domain.persistence.UserAccount;
import com.sparabox.domain.persistence.UserAccountId;
import com.sparabox.repository.AccountRepository;
import com.sparabox.repository.TransactionRepository;
import com.sparabox.repository.UserAccountRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountFlowImpl implements AccountFlow {

    private final AccountRepository accountRepository;
    private final UserAccountRespository userAccountRespository;
    private final TransactionRepository transactionRepository;

    @Autowired
    public AccountFlowImpl(AccountRepository accountRepository,
                           UserAccountRespository userAccountRespository,
                           TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.userAccountRespository = userAccountRespository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Boolean hasAccountLinked(String userId) {
        UserAccount userAccount = userAccountRespository.findByUserAccountId_UserId(userId);
        return null != userAccount;
    }

    @Override
    public Boolean validateAccountNumber(Long accountNumber) {
        Account account = accountRepository.findByAccountNumber(accountNumber);
        return null != account;
    }

    @Override
    public Boolean linkUserToAccount(String userId, Long accountNumber, String lastCardNumber) {
        Transaction latestTransaction = transactionRepository.findTopByAccount_AccountNumberOrderByTransactionDateTimeDesc(accountNumber);

        if (null == latestTransaction) {
            throw new SparaBoxException("No transactions recorded for given account number.");
        }

        if (latestTransaction.getCard().getCardNumber().endsWith(lastCardNumber)) {
            UserAccount userAccount = new UserAccount(new UserAccountId(userId, accountNumber));
            userAccountRespository.save(userAccount);
            return true;
        }

        throw new SparaBoxException("Given card number does not match latest transaction.");
    }

    @Override
    public Boolean linkUserToMessageToken(String userId, String messageToken) {
        UserAccount userAccount = userAccountRespository.findByUserAccountId_UserId(userId);
        if(null == userAccount) {
            throw new SparaBoxException("No user account with the given user id.");
        }
        userAccount.setMessageToken(messageToken);
        userAccountRespository.save(userAccount);
        return true;
    }

    @Override
    public UserAccount getAccountByAccountNumber(Long accountNumber) {
        return userAccountRespository.findByUserAccountId_AccountNumber(accountNumber);
    }
}
