package com.sparabox.domain.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DashboardDto implements Serializable {
    private static final long serialVersionUID = 7370969820349650277L;

    private Boolean accountLinked;
    private Double availableBalance;
    private Double spentToday;
    private List<TransactionDto> recentTransactions;

    public DashboardDto() {
        this.availableBalance = 1500.0;
        this.spentToday = 785.4;
    }

    public DashboardDto(Boolean accountLinked, List<TransactionDto> recentTransactions) {
        this.availableBalance = 1500.0;
        this.spentToday = 785.4;
        this.accountLinked = accountLinked;
        this.recentTransactions = recentTransactions;
    }

    public Boolean getAccountLinked() {
        return accountLinked;
    }

    public void setAccountLinked(Boolean accountLinked) {
        this.accountLinked = accountLinked;
    }

    public List<TransactionDto> getRecentTransactions() {
        if (null == recentTransactions) {
            recentTransactions = new ArrayList<>();
        }
        return recentTransactions;
    }

    public void setRecentTransactions(List<TransactionDto> recentTransactions) {
        this.recentTransactions = recentTransactions;
    }

    public Double getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(Double availableBalance) {
        this.availableBalance = availableBalance;
    }

    public Double getSpentToday() {
        return spentToday;
    }

    public void setSpentToday(Double spentToday) {
        this.spentToday = spentToday;
    }
}
