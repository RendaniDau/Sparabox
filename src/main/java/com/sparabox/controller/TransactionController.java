package com.sparabox.controller;

import com.sparabox.business.TransactionFlow;
import com.sparabox.domain.business.TransactionDto;
import com.sparabox.domain.persistence.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionController.class);

    private final TransactionFlow transactionFlow;

    @Autowired
    public TransactionController(TransactionFlow transactionFlow) {
        this.transactionFlow = transactionFlow;
    }

    @GetMapping
    @ResponseBody
    public List<TransactionDto> getTransactionsPaged(Principal principal, Pageable pageable) {
        LOGGER.info("Getting transactions for user {}", principal.getName());
        return transactionFlow.getUserTransactionsPaged(principal.getName(), pageable);
    }
}
