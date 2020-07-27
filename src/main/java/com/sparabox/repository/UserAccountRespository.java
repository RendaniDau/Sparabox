package com.sparabox.repository;

import com.sparabox.domain.persistence.UserAccount;
import com.sparabox.domain.persistence.UserAccountId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRespository extends JpaRepository<UserAccount, UserAccountId> {
    UserAccount findByUserAccountId(UserAccountId userAccountId);

    UserAccount findByUserAccountId_UserId(String userId);

    UserAccount findByUserAccountId_AccountNumber(Long userId);
}
