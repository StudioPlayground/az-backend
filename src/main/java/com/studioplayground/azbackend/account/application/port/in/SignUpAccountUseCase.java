package com.studioplayground.azbackend.account.application.port.in;

import com.studioplayground.azbackend.account.domain.model.aggregate.Account;
import com.studioplayground.azbackend.account.domain.model.commands.CreateAccountCommand;

public interface SignUpAccountUseCase {
    Account create(CreateAccountCommand createAccountCommand);
}
