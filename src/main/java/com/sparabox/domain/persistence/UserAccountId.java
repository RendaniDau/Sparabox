package com.sparabox.domain.persistence;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UserAccountId implements Serializable {
    private static final long serialVersionUID = 2423916232931973057L;

    @Column(name = "USER_ID", nullable = false)
    private String userId;
    @Column(name = "ACCOUNT_NUMBER", nullable = false)
    private Long accountNumber;

    public UserAccountId() {
    }

    public UserAccountId(String userId, Long accountId) {
        this.userId = userId;
        this.accountNumber = accountId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountId) {
        this.accountNumber = accountId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserAccountId)) return false;
        UserAccountId that = (UserAccountId) o;
        return userId.equals(that.userId) &&
                accountNumber.equals(that.accountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, accountNumber);
    }
}
