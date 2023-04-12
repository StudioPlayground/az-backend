package com.studioplayground.azbackend.account.application.port.out;

import com.studioplayground.azbackend.account.domain.aggregate.Account;

public interface UpdateAccountPort {
    Account update(Account account);
}
