package com.studioplayground.azbackend.account.application.service;

import com.studioplayground.azbackend.account.application.port.in.DeleteAccountUseCase;
import com.studioplayground.azbackend.account.application.port.in.ForceDeleteAccountUseCase;
import com.studioplayground.azbackend.account.application.port.in.SignUpAccountUseCase;
import com.studioplayground.azbackend.account.application.port.out.CreateAccountPort;
import com.studioplayground.azbackend.account.application.port.out.DeleteAccountPort;
import com.studioplayground.azbackend.account.domain.aggregate.Account;
import com.studioplayground.azbackend.account.domain.model.AccountId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateDeleteAccountService implements SignUpAccountUseCase, DeleteAccountUseCase
        , ForceDeleteAccountUseCase {
    private final CreateAccountPort createAccountPort;
    private final DeleteAccountPort deleteAccountPort;

    @Override
    public AccountId signUp(Account account) {
        return createAccountPort.create(account);
    }

    @Override
    public void delete(AccountId id) {
        deleteAccountPort.delete(id);
    }

    @Override
    public void forceDelete(AccountId id) {
        deleteAccountPort.delete(id);
    }
}
