package com.studioplayground.azbackend.account.infrastructure.adapter.out.persistence.model;

import com.studioplayground.azbackend.account.domain.aggregate.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccountJpaEntityMapper {
    AccountJpaEntityMapper INSTANCE = Mappers.getMapper(AccountJpaEntityMapper.class);

    @Mappings({
            @Mapping(target = "id", source = "account.id.id")
            , @Mapping(target = "email", source = "account.email.email")
    })
    AccountJpaEntity toJpaEntity(Account account);

    @Mappings({
            @Mapping(target = "id", expression = "java(new AccountId(accountJpaEntity.id))")
            , @Mapping(target = "email", source = "java(new Email(accountJpaEntity.email))")
    })
    Account fromJpaEntity(AccountJpaEntity accountJpaEntity);
}
