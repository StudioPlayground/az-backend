package com.studioplayground.azbackend.account.application.port.in;

import com.studioplayground.azbackend.account.domain.aggregate.Account;

public interface SignUpAccountUseCase {
    Account signUp();
}
