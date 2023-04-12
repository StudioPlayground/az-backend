package com.studioplayground.azbackend.account.application.port.out;

import com.studioplayground.azbackend.account.domain.aggregate.Account;
import com.studioplayground.azbackend.account.domain.model.AccountId;

public interface CreateAccountPort {
    AccountId create(Account account);
}
