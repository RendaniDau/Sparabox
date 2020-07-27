package com.sparabox.business.impl;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import com.sparabox.business.AccountFlow;
import com.sparabox.business.NotificationFlow;
import com.sparabox.business.TransactionFlow;
import com.sparabox.domain.persistence.Transaction;
import com.sparabox.domain.persistence.UserAccount;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NotificationFlowImpl implements NotificationFlow {

    private final TransactionFlow transactionFlow;
    private final AccountFlow accountFlow;

    public NotificationFlowImpl(TransactionFlow transactionFlow, AccountFlow accountFlow) {
        this.transactionFlow = transactionFlow;
        this.accountFlow = accountFlow;
    }

    @Override
    public void sendTrxNotification(Long trxId) {
        Optional<Transaction> transactionOptional = transactionFlow.getTransactionById(trxId);

        if (transactionOptional.isPresent()) {
            Transaction transaction = transactionOptional.get();
            UserAccount userAccount = accountFlow.getAccountByAccountNumber(transaction.getAccount().getAccountNumber());
            if (null != userAccount) {
                Message message = Message.builder()
                        .setNotification(buildNotification(transaction))
                        .setToken(userAccount.getMessageToken())
                        .build();

                try {
                    FirebaseMessaging.getInstance().send(message);
                } catch (FirebaseMessagingException e) {
                    e.printStackTrace();

                }
            }
        }
    }

    private Notification buildNotification(Transaction transaction) {
        Double trxAmount = transaction.getAmount() / 1000D;
        return Notification.builder()
                .setTitle("New Transaction")
                .setBody(String.format("Hello, you have spent R%f at merchant %s", trxAmount, transaction.getMerchant().getName()))
                .build();
    }
}
