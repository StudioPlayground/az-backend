package com.studioplayground.azbackend.account.infrastructure.adapter.in.rest;

import com.studioplayground.azbackend.account.application.port.in.DeleteAccountUseCase;
import com.studioplayground.azbackend.account.application.port.in.SignUpAccountUseCase;
import com.studioplayground.azbackend.account.domain.model.aggregate.Account;
import com.studioplayground.azbackend.account.infrastructure.adapter.in.rest.model.AccountResponseDto;
import com.studioplayground.azbackend.account.infrastructure.adapter.in.rest.model.CreateAccountRequestDto;
import com.studioplayground.azbackend.common.infrastructure.adapter.in.rest.model.SuccessResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountRestController {

    private final SignUpAccountUseCase createAccountUseCase;

    private final DeleteAccountUseCase deleteAccountUseCase;

    @PostMapping("/api/v1/accounts")
    SuccessResponse<AccountResponseDto> create(@Valid CreateAccountRequestDto request) {
        final Account account = createAccountUseCase.create(request);
        return SuccessResponse.of(AccountResponseDto.from(account));
    }

    @DeleteMapping("/api/v1/accounts/{id}")
    SuccessResponse<?> delete(@PathVariable Long id) {
        deleteAccountUseCase.delete(id);
        return SuccessResponse.of();
    }
}
