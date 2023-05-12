package com.studioplayground.azbackend.account.applcation.service.command;

import com.studioplayground.azbackend.account.applcation.port.in.CreateAccountUseCase;
import com.studioplayground.azbackend.account.applcation.port.in.model.CreateAccountCommand;
import com.studioplayground.azbackend.account.applcation.port.out.CreateAccountPort;
import com.studioplayground.azbackend.account.domain.model.Account;
import com.studioplayground.azbackend.common.annotation.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@Transactional
@RequiredArgsConstructor
public class CreateDeleteAccountService implements CreateAccountUseCase {

    private final CreateAccountPort createAccountPort;

    public Account create(Account account) {
        return createAccountPort.create(account);
    }

    @Override
    public Account create(CreateAccountCommand command) {
        return null;
    }
}
