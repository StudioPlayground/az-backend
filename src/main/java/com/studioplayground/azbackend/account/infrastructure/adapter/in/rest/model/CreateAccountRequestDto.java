package com.studioplayground.azbackend.account.infrastructure.adapter.in.rest.model;

import com.studioplayground.azbackend.account.domain.model.aggregate.Account;
import com.studioplayground.azbackend.account.domain.model.aggregate.AccountProfile;
import com.studioplayground.azbackend.account.domain.model.aggregate.AccountRole;
import com.studioplayground.azbackend.account.domain.model.aggregate.AccountStatus;
import com.studioplayground.azbackend.account.domain.model.aggregate.Gender;
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

    public Account toDomainModel() {
        return Account.withOutId(birthDate, Gender.from(gender), com.studioplayground.azbackend.account.domain.model.aggregate.Email.from(email), name,
            AccountStatus.from(status), AccountRole.from(role), AccountProfile.from(profileNickName, url));
    }
}
