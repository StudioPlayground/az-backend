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
    public Account forceSuspend(AccountId id) {
        final Account account = readAccountPort.read(id);
        account.suspend();

        return updateAccountPort.update(account);
    }

    @Override
    public Account expireSuspension(AccountId id) {
        return doUnSuspend(id);
    }

    @Override
    public Account unSuspend(AccountId id) {
        return doUnSuspend(id);
    }

    @Override
    public Account updateProfile(AccountId id, AccountProfile profile) {
        final Account account = readAccountPort.read(id);
        account.updateProfile(profile);

        return updateAccountPort.update(account);
    }

    private Account doUnSuspend(AccountId id) {
        final Account account = readAccountPort.read(id);
        account.unSuspend();

        return updateAccountPort.update(account);
    }
}
