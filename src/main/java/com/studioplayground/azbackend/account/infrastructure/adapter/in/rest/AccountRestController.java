package com.studioplayground.azbackend.account.infrastructure.adapter.in.rest;

import com.studioplayground.azbackend.account.application.port.in.ReadAccountUseCase;
import com.studioplayground.azbackend.account.application.port.in.SignUpAccountUseCase;
import com.studioplayground.azbackend.account.domain.model.aggregate.Account;
import com.studioplayground.azbackend.account.infrastructure.adapter.in.rest.model.AccountResponseDto;
import com.studioplayground.azbackend.account.infrastructure.adapter.in.rest.model.CreateAccountRequestDto;
import com.studioplayground.azbackend.common.infrastructure.adapter.in.rest.model.SuccessResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountRestController {

    private final SignUpAccountUseCase createAccountUseCase;
    private final ReadAccountUseCase readAccountUseCase;

    @PostMapping("/api/v1/accounts")
    SuccessResponse<AccountResponseDto> create(@Valid CreateAccountRequestDto request) {
        final Account account = createAccountUseCase.create(request);
        return SuccessResponse.of(AccountResponseDto.from(account));
    }

    @GetMapping("/api/v1/account")
    SuccessResponse<AccountResponseDto> get(@Email String email) {
        final var account = readAccountUseCase.get(email);
        return SuccessResponse.of(AccountResponseDto.from(account));
    }
}
