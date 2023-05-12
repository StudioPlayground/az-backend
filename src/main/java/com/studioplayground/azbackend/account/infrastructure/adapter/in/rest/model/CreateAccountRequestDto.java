package com.studioplayground.azbackend.account.infrastructure.adapter.in.rest.model;

import static lombok.AccessLevel.PROTECTED;

import com.studioplayground.azbackend.account.applcation.port.in.model.CreateAccountCommand;
import com.studioplayground.azbackend.account.domain.model.Gender;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = PROTECTED)
public class CreateAccountRequestDto {

    @NotNull
    private LocalDate birthDate;
    @NotNull
    private Gender gender;
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
            com.studioplayground.azbackend.common.domain.model.Email.from(email), name.toName(),
            profile.toProfile(), key.toProviderKey());


    }


}

