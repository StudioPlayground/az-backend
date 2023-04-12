package com.studioplayground.azbackend.account.application.port.in;

import com.studioplayground.azbackend.account.domain.model.AccountId;

public interface SignOutAccountUseCase {
    void signOut(AccountId id);
}
