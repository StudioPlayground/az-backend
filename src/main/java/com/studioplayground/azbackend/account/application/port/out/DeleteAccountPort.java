package com.studioplayground.azbackend.account.application.port.out;

import com.studioplayground.azbackend.account.domain.model.aggregate.AccountId;

public interface DeleteAccountPort {

    void delete(AccountId accountId);
}
