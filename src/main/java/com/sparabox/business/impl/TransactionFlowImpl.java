package com.sparabox.business.impl;

import com.sparabox.business.TransactionFlow;
import com.sparabox.domain.business.TransactionDto;
import com.sparabox.domain.exception.SparaBoxException;
import com.sparabox.domain.persistence.Transaction;
import com.sparabox.domain.persistence.UserAccount;
import com.sparabox.repository.TransactionRepository;
import com.sparabox.repository.UserAccountRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionFlowImpl implements TransactionFlow {

    private final TransactionRepository transactionRepository;
    private final UserAccountRespository userAccountRespository;

    @Autowired
    public TransactionFlowImpl(TransactionRepository transactionRepository, UserAccountRespository userAccountRespository) {
        this.transactionRepository = transactionRepository;
        this.userAccountRespository = userAccountRespository;
    }

    @Override
    public List<TransactionDto> getUserTransactionsPaged(String userId, Pageable pageable) {
        UserAccount userAccount = userAccountRespository.findByUserAccountId_UserId(userId);
        if (null == userAccount) {
            throw new SparaBoxException("No account linked to user.");
        }
        List<TransactionDto> transactionDtoList = new ArrayList<>();
        List<Transaction> transactions = transactionRepository.findByAccount_AccountNumberOrderByTransactionDateTimeDesc(userAccount.getUserAccountId().getAccountNumber(), pageable);

        for (Transaction transaction : transactions) {
            transactionDtoList.add(new TransactionDto(transaction));
        }

        return transactionDtoList;
    }

    @Override
    public Optional<Transaction> getTransactionById(Long trxId) {
        return transactionRepository.findById(trxId);
    }
}
