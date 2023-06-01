package com.studioplayground.azbackend.account.application.service;


import com.studioplayground.azbackend.account.application.port.in.DeleteAccountUseCase;
import com.studioplayground.azbackend.account.application.port.in.SignUpAccountUseCase;
import com.studioplayground.azbackend.account.application.port.out.CreateAccountPort;
import com.studioplayground.azbackend.account.application.port.out.DeleteAccountPort;
import com.studioplayground.azbackend.account.domain.model.aggregate.Account;
import com.studioplayground.azbackend.account.domain.model.aggregate.AccountId;
import com.studioplayground.azbackend.account.infrastructure.adapter.in.rest.model.CreateAccountRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateDeleteAccountService implements SignUpAccountUseCase, DeleteAccountUseCase {

    private final CreateAccountPort createAccountPort;
    private final DeleteAccountPort deleteAccountPort;

    @Override
    public Account create(CreateAccountRequestDto createAccountRequestDto) {
        return createAccountPort.create(createAccountRequestDto.toDomainModel());
    }

    @Override
    public void delete(AccountId accountId) {
        deleteAccountPort.delete(accountId);
    }
}
