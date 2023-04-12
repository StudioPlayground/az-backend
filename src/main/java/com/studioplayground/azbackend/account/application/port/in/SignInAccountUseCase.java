package com.studioplayground.azbackend.account.application.port.in;

import com.studioplayground.azbackend.account.domain.model.AccountId;

public interface SignInAccountUseCase {
    void signIn(AccountId id);
}
