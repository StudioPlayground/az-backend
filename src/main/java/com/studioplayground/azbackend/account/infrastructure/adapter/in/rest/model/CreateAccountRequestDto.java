package com.studioplayground.azbackend.account.infrastructure.adapter.in.rest.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import java.time.LocalDate;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CreateAccountRequestDto {

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
}
