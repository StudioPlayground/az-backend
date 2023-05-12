package com.studioplayground.azbackend.account.applcation.port.in;

import com.studioplayground.azbackend.account.applcation.port.in.model.CreateAccountCommand;
import com.studioplayground.azbackend.account.domain.model.Account;

public interface CreateAccountUseCase {

    Account create(CreateAccountCommand command);

}
