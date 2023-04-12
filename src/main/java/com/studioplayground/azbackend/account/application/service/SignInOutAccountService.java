package com.studioplayground.azbackend.account.application.service;

import com.studioplayground.azbackend.account.application.port.in.SignInAccountUseCase;
import com.studioplayground.azbackend.account.application.port.in.SignOutAccountUseCase;
import com.studioplayground.azbackend.account.application.port.out.ReadAccountPort;
import com.studioplayground.azbackend.account.domain.model.AccountId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignInOutAccountService implements SignOutAccountUseCase, SignInAccountUseCase {
    private final ReadAccountPort readAccountPort;

    @Override
    public void signIn(AccountId id) {
        readAccountPort.read(id);
    }

    @Override
    public void signOut(AccountId id) {
        readAccountPort.read(id);
    }
}
