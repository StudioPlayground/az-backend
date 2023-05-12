package com.studioplayground.azbackend.account.applcation.port.out;

import com.studioplayground.azbackend.account.domain.model.Account;

public interface CreateAccountPort {
    Account create(Account account);
}
