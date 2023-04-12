package com.studioplayground.azbackend.account.infrastructure.adapter.out.persistence.model;

import com.studioplayground.azbackend.account.domain.aggregate.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccountJapEntityMapper {
    AccountJapEntityMapper INSTANCE = Mappers.getMapper(AccountJapEntityMapper.class);

    @Mappings({
            @Mapping(target = "id", source = "account.id.id")
            , @Mapping(target = "email", source = "account.email.email")
    })
    AccountJpaEntity toJpaEntity(Account account);

    @Mappings({
            @Mapping(target = "id", expression = "java(new AccountId(accountJapEntity.id))")
            , @Mapping(target = "email", source = "java(new Email(accountJapEntity.email))")
    })
    Account fromJapEntity(AccountJpaEntity accountJpaEntity);
}
