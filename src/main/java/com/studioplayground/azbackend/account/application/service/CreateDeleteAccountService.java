package com.studioplayground.azbackend.account.application.service;


import com.studioplayground.azbackend.account.application.port.in.SignUpAccountUseCase;
import com.studioplayground.azbackend.account.application.port.out.CreateAccountPort;
import com.studioplayground.azbackend.account.domain.model.aggregate.Account;
import com.studioplayground.azbackend.account.domain.model.commands.CreateAccountCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateDeleteAccountService implements SignUpAccountUseCase {

    private final CreateAccountPort createAccountPort;

    @Override
    public Account create(CreateAccountCommand command) {
        return createAccountPort.create(command.toDomainModel());
    }
}
