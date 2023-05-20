package com.studioplayground.azbackend.account.domain.model.commands;

import com.studioplayground.azbackend.account.domain.model.aggregate.Account;
import com.studioplayground.azbackend.account.domain.model.aggregate.AccountProfile;
import com.studioplayground.azbackend.account.domain.model.aggregate.AccountRole;
import com.studioplayground.azbackend.account.domain.model.aggregate.AccountStatus;
import com.studioplayground.azbackend.account.domain.model.aggregate.Email;
import com.studioplayground.azbackend.account.domain.model.aggregate.Gender;
import java.time.LocalDate;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CreateAccountCommand {

    private LocalDate birthDate;
    private String gender;

    private String email;

    private String name;

    private String profileNickName;
    private String url;
    private String status;
    private String role;

    public Account toDomainModel() {
        return Account.withOutId(birthDate, Gender.from(gender), Email.from(email), name,
                AccountStatus.from(status), AccountRole.from(role), AccountProfile.from(profileNickName, url));
    }
}



