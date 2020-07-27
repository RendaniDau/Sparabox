package com.sparabox.business.impl;

import com.sparabox.business.AccountFlow;
import com.sparabox.business.DashboardFlow;
import com.sparabox.business.TransactionFlow;
import com.sparabox.domain.business.DashboardDto;
import com.sparabox.domain.business.TransactionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class DashboardFlowImpl implements DashboardFlow {

    private final AccountFlow accountFlow;
    private final TransactionFlow transactionFlow;

    @Autowired
    public DashboardFlowImpl(AccountFlow accountFlow, TransactionFlow transactionFlow) {
        this.accountFlow = accountFlow;
        this.transactionFlow = transactionFlow;
    }

    @Override
    public DashboardDto getDashboard(String userId) {
        DashboardDto dashboardDto;

        if (accountFlow.hasAccountLinked(userId)) {
            List<TransactionDto> transactionDtoList = transactionFlow.getUserTransactionsPaged(userId, PageRequest.of(0, 3));
            dashboardDto = new DashboardDto(Boolean.TRUE, transactionDtoList);
        } else {
            dashboardDto = new DashboardDto(Boolean.FALSE, Collections.emptyList());
        }
        return dashboardDto;
    }
}
