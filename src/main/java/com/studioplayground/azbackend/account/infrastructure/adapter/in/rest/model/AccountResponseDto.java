package com.studioplayground.azbackend.account.infrastructure.adapter.in.rest.model;

import com.studioplayground.azbackend.account.domain.model.aggregate.Account;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import java.time.LocalDate;
import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PRIVATE)
public class AccountResponseDto {

    @NotNull
    private LocalDate birthDate;
    @Pattern(regexp = "MALE|FEMALE|NON_BINARY")
    private String gender;
    @Email
    private String email;
    @NotNull
    private String name;

    private String profileNickName;
    private String url;
    private String status;
    private String role;

    public static AccountResponseDto from(Account account) {
        return AccountResponseDto.builder()
                .birthDate(account.getBirthDate())
                .gender(account.getGender().name())
                .email(account.getEmail().email())
                .name(account.getName())
                .profileNickName(account.getProfile().profileNickName().nickName())
                .url(account.getProfile().profileUrl().url())
                .role(account.getRole().name())
                .build();
    }
}
