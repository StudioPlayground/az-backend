package com.studioplayground.azbackend.account.application.service;

import com.studioplayground.azbackend.account.application.port.in.ReadAccountUseCase;
import com.studioplayground.azbackend.account.application.port.out.ReadAccountPort;
import com.studioplayground.azbackend.account.domain.model.aggregate.Account;
import com.studioplayground.azbackend.account.domain.model.aggregate.Email;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReadAccountService implements ReadAccountUseCase {

    private final ReadAccountPort readAccountPort;

    @Override
    public Account get(String email) {
        final var emailModel = Email.from(email);
        return readAccountPort.get(emailModel);
    }
}
