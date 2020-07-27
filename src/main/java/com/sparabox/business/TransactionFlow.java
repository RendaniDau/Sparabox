package com.sparabox.business;

import com.sparabox.domain.business.TransactionDto;
import com.sparabox.domain.persistence.Transaction;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface TransactionFlow {
    List<TransactionDto> getUserTransactionsPaged(String userId, Pageable pageable);
    Optional<Transaction> getTransactionById(Long trxId);
}
