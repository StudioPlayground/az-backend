package com.studioplayground.azbackend.account.infrastructure.adapter.out.persistence;

import com.studioplayground.azbackend.account.application.port.out.UpdateAccountPort;
import com.studioplayground.azbackend.account.domain.aggregate.Account;
import com.studioplayground.azbackend.account.infrastructure.adapter.out.persistence.model.AccountJpaEntity;
import com.studioplayground.azbackend.account.infrastructure.adapter.out.persistence.model.AccountJpaEntityMapper;
import com.studioplayground.azbackend.account.infrastructure.adapter.out.persistence.repository.AccountJpaRepository;
import com.studioplayground.azbackend.common.annotaion.Adaptor;
import lombok.RequiredArgsConstructor;

@Adaptor
@RequiredArgsConstructor
public class UpdateAccountJpaAdaptor implements UpdateAccountPort {
    private final AccountJpaRepository accountJpaRepository;

    @Override
    public Account update(Account account) {
        final AccountJpaEntity updateResult = accountJpaRepository.save(
                AccountJpaEntityMapper.INSTANCE.toJpaEntity(account)
        );

        return AccountJpaEntityMapper.INSTANCE.fromJpaEntity(updateResult);
    }
}
