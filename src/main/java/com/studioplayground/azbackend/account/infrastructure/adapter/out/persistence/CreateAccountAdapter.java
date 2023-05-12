package com.studioplayground.azbackend.account.infrastructure.adapter.out.persistence;

import com.studioplayground.azbackend.account.applcation.port.out.CreateAccountPort;
import com.studioplayground.azbackend.account.domain.model.Account;
import com.studioplayground.azbackend.account.infrastructure.adapter.out.persistence.model.AccountJpaModel;
import com.studioplayground.azbackend.account.infrastructure.adapter.out.persistence.repository.AccountRepository;
import com.studioplayground.azbackend.common.annotation.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class CreateAccountAdapter implements CreateAccountPort {
    private final AccountRepository accountRepository;


    @Override
    public Account create(Account account) {
        AccountJpaModel accountJpaModel = AccountJpaModel.from(account);
        accountJpaModel = accountRepository.save(accountJpaModel);
        return accountJpaModel.toDomainModel();
    }
}
