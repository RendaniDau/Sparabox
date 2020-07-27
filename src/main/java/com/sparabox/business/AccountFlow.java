package com.sparabox.business;

import com.sparabox.domain.persistence.UserAccount;

public interface AccountFlow {

    Boolean hasAccountLinked(String userId);

    Boolean validateAccountNumber(Long accountNumber);

    Boolean linkUserToAccount(String userId, Long accountNumber, String lastCardNumber);

    Boolean linkUserToMessageToken(String userId, String messageToken);

    UserAccount getAccountByAccountNumber(Long accountNumber);
}
