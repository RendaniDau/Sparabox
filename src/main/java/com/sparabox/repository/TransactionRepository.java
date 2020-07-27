package com.sparabox.repository;

import com.sparabox.domain.persistence.Transaction;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByCard_CardNumberOrderByTransactionDateTimeDesc(String cardNumber);

    Transaction findTopByAccount_AccountNumberOrderByTransactionDateTimeDesc(Long accountNumber);

    List<Transaction> findByAccount_AccountNumberOrderByTransactionDateTimeDesc(Long accountNumber, Pageable pageable);
}
