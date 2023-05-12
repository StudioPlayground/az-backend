package com.studioplayground.azbackend.account.applcation.port.in.model;

import com.studioplayground.azbackend.account.domain.model.Account;
import com.studioplayground.azbackend.account.domain.model.AccountProfile;
import com.studioplayground.azbackend.account.domain.model.AccountRole;
import com.studioplayground.azbackend.account.domain.model.Gender;
import com.studioplayground.azbackend.account.domain.model.Name;
import com.studioplayground.azbackend.account.domain.model.ProviderKey;
import com.studioplayground.azbackend.common.domain.model.Email;
import java.time.LocalDate;

public record CreateAccountCommand(
    LocalDate birthDate,
    Gender gender,
    Email email,
    Name name,
    AccountProfile profile,
    ProviderKey key
) {

    public Account toDomainModel() {
        return Account.withOutId(birthDate, gender, email, name, AccountRole.GENERAL_USER, profile,
            key);
    }
}
