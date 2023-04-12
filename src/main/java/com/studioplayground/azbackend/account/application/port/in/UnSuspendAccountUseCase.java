package com.studioplayground.azbackend.account.application.port.in;

import com.studioplayground.azbackend.account.domain.aggregate.Account;
import com.studioplayground.azbackend.account.domain.model.AccountId;

public interface UnSuspendAccountUseCase {
    Account unSuspend(AccountId id);
}
