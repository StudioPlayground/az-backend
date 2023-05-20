package com.studioplayground.azbackend.account.application.port.out;

import com.studioplayground.azbackend.account.domain.model.aggregate.Account;

public interface CreateAccountPort {
    Account create(Account account);
}
