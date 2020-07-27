package com.sparabox.domain.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "ACCOUNT", schema = "SPA_BOX")
public class Account implements Serializable {
    private static final long serialVersionUID = -4344283941196507052L;

    @Id
    @Column(name = "ACCOUNT_NUMBER")
    private Long accountNumber;

    public Account() {
    }

    public Account(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }
}
