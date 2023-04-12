package com.studioplayground.azbackend.account.application.service;

import com.studioplayground.azbackend.account.application.port.in.ExpireSuspensionAccountUseCase;
import com.studioplayground.azbackend.account.application.port.in.ForceSuspendAccountUseCase;
import com.studioplayground.azbackend.account.application.port.in.UnSuspendAccountUseCase;
import com.studioplayground.azbackend.account.application.port.in.UpdateAccountProfileUseCase;
import com.studioplayground.azbackend.account.application.port.out.ReadAccountPort;
import com.studioplayground.azbackend.account.application.port.out.UpdateAccountPort;
import com.studioplayground.azbackend.account.domain.aggregate.Account;
import com.studioplayground.azbackend.account.domain.model.AccountId;
import com.studioplayground.azbackend.account.domain.model.AccountProfile;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateAccountService implements ForceSuspendAccountUseCase, ExpireSuspensionAccountUseCase
        , UnSuspendAccountUseCase, UpdateAccountProfileUseCase {
    private final ReadAccountPort readAccountPort;
    private final UpdateAccountPort updateAccountPort;

    @Override
    public void forceSuspend(AccountId id) {
        final Account account = readAccountPort.read(id);
        account.suspend();

        updateAccountPort.update(account);
    }

    @Override
    public void expireSuspension(AccountId id) {
        doUnSuspend(id);
    }

    @Override
    public void unSuspend(AccountId id) {
        doUnSuspend(id);
    }

    @Override
    public void updateProfile(AccountId id, AccountProfile profile) {
        final Account account = readAccountPort.read(id);
        account.updateProfile(profile);

        updateAccountPort.update(account);
    }

    private void doUnSuspend(AccountId id) {
        final Account account = readAccountPort.read(id);
        account.unSuspend();

        updateAccountPort.update(account);
    }
}
