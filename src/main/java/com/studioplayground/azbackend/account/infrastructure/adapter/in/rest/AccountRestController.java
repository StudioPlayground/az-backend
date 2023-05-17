package com.studioplayground.azbackend.account.infrastructure.adapter.in.rest;

import com.studioplayground.azbackend.account.applcation.port.in.CreateAccountUseCase;
import com.studioplayground.azbackend.account.domain.model.Account;
import com.studioplayground.azbackend.account.infrastructure.adapter.in.rest.model.AccountResponseDto;
import com.studioplayground.azbackend.account.infrastructure.adapter.in.rest.model.CreateAccountRequestDto;
import com.studioplayground.azbackend.infrastructure.adapter.in.rest.model.SuccessResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountRestController {

    private final CreateAccountUseCase createAccountUseCase;

    @PostMapping("/api/v1/accounts")
    SuccessResponse<AccountResponseDto> create(@Valid CreateAccountRequestDto request) {
        final Account account = createAccountUseCase.create(request.toCommand());
        return SuccessResponse.of(AccountResponseDto.from(account));
    }
}
