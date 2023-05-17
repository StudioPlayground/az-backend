package com.studioplayground.azbackend.account.infrastructure.adapter.in.rest.model;

import static lombok.AccessLevel.PROTECTED;

import com.studioplayground.azbackend.account.applcation.port.in.model.CreateAccountCommand;
import com.studioplayground.azbackend.account.domain.model.Gender;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import java.time.LocalDate;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = PROTECTED)
public class CreateAccountRequestDto {

    @NotNull
    private LocalDate birthDate;
    @Pattern(regexp = "MALE|FEMALE|NON_BINARY")
    private String gender;
    @Email
    private String email;
    @NotNull
    private NameRequestDto name;
    @NotNull
    private AccountProfileRequestDto profile;
    @NotNull
    private ProviderKeyRequestDto key;

    public CreateAccountCommand toCommand() {
        return new CreateAccountCommand(birthDate, gender,
            email, name.toCommand(),
            profile.toCommand(), key.toCommand());


    }


}

