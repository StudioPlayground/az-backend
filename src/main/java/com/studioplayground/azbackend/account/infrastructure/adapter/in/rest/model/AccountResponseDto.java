package com.studioplayground.azbackend.account.infrastructure.adapter.in.rest.model;

import com.studioplayground.azbackend.account.domain.model.Account;
import java.time.LocalDate;


public record AccountResponseDto(Long accountId, LocalDate birthDate, String gender, String email,
                                 AccountProfileResponseDto profile
) {

    public static AccountResponseDto from(Account account) {
        return new AccountResponseDto(account.getId().id(), account.getBirthDate(),
            account.getGender().name(), account.getEmail().email(),
            AccountProfileResponseDto.from(account.getProfile()));
    }
}
