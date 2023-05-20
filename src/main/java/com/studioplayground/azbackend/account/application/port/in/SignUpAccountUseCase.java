package com.studioplayground.azbackend.account.application.port.in;

import com.studioplayground.azbackend.account.domain.model.aggregate.Account;
import com.studioplayground.azbackend.account.infrastructure.adapter.in.rest.model.CreateAccountRequestDto;

public interface SignUpAccountUseCase {
    Account create(CreateAccountRequestDto createAccountRequestDto);
}
