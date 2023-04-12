package com.studioplayground.azbackend.account.infrastructure.adapter.out.persistence;

import com.studioplayground.azbackend.account.application.port.out.CreateAccountPort;
import com.studioplayground.azbackend.account.application.port.out.DeleteAccountPort;
import com.studioplayground.azbackend.account.domain.aggregate.Account;
import com.studioplayground.azbackend.account.domain.model.AccountId;
import com.studioplayground.azbackend.account.infrastructure.adapter.out.persistence.model.AccountJpaEntity;
import com.studioplayground.azbackend.account.infrastructure.adapter.out.persistence.model.AccountJpaEntityMapper;
import com.studioplayground.azbackend.account.infrastructure.adapter.out.persistence.repository.AccountJpaRepository;
import com.studioplayground.azbackend.common.annotaion.Adaptor;
import lombok.RequiredArgsConstructor;

@Adaptor
@RequiredArgsConstructor
public class CreateDeleteAccountJpaAdaptor implements CreateAccountPort, DeleteAccountPort {
    private final AccountJpaRepository accountJpaRepository;

    @Override
    public Account create(Account account) {
        final AccountJpaEntity saveResult = accountJpaRepository.save(
                AccountJpaEntityMapper.INSTANCE.toJpaEntity(account)
        );

        return AccountJpaEntityMapper.INSTANCE.fromJpaEntity(saveResult);
    }

    @Override
    public void delete(AccountId id) {
        accountJpaRepository.deleteById(id.id());
    }
}
