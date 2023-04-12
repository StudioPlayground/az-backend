package com.studioplayground.azbackend.account.application.port.out;

import com.studioplayground.azbackend.account.domain.model.AccountId;

public interface DeleteAccountPort {
    void delete(AccountId id);
}
