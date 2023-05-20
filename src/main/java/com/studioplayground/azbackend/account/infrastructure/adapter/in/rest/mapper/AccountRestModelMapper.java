package com.studioplayground.azbackend.account.infrastructure.adapter.in.rest.mapper;

import com.studioplayground.azbackend.account.domain.model.commands.CreateAccountCommand;
import com.studioplayground.azbackend.account.infrastructure.adapter.in.rest.model.CreateAccountRequestDto;
import org.mapstruct.Mapper;

@Mapper
public interface AccountRestModelMapper {
    CreateAccountCommand toCommand(CreateAccountRequestDto createAccountRequestDto);
}
