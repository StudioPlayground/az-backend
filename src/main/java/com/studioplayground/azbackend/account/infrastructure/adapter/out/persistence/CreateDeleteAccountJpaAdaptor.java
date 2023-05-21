package com.studioplayground.azbackend.account.infrastructure.adapter.out.persistence;

import com.studioplayground.azbackend.account.application.port.out.CreateAccountPort;
import com.studioplayground.azbackend.account.domain.model.aggregate.Account;
import com.studioplayground.azbackend.account.infrastructure.adapter.out.persistence.model.AccountJPAEntity;
import com.studioplayground.azbackend.account.infrastructure.adapter.out.persistence.repository.AccountJPARepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateDeleteAccountJpaAdaptor implements CreateAccountPort {

    private final AccountJPARepository accountJPARepository;

    @Override
    public Account create(Account account) {
        AccountJPAEntity accountJPAEntity = AccountJPAEntity.from(account);
        return accountJPARepository.save(accountJPAEntity).toDomainModel();
    }
}
