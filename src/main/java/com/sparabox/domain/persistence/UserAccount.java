package com.sparabox.domain.persistence;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "USER_ACCOUNT", schema = "SPA_BOX")
public class UserAccount implements Serializable {
    private static final long serialVersionUID = 5904887603973166647L;

    @EmbeddedId
    private UserAccountId userAccountId;

    @Column(name = "MESSAGE_TOKEN")
    private String messageToken;

    public UserAccount() {
    }

    public UserAccount(UserAccountId userAccountId) {
        this.userAccountId = userAccountId;
    }

    public UserAccountId getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(UserAccountId userAccountId) {
        this.userAccountId = userAccountId;
    }

    public String getMessageToken() {
        return messageToken;
    }

    public void setMessageToken(String messageToken) {
        this.messageToken = messageToken;
    }
}
