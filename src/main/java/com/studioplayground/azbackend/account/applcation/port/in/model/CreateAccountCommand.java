package com.studioplayground.azbackend.account.applcation.port.in.model;

import com.studioplayground.azbackend.account.domain.model.Account;
import com.studioplayground.azbackend.account.domain.model.AccountRole;
import com.studioplayground.azbackend.account.domain.model.Gender;
import com.studioplayground.azbackend.account.domain.model.ProviderKey;
import com.studioplayground.azbackend.common.domain.model.Email;
import java.time.LocalDate;

public record CreateAccountCommand(
    LocalDate birthDate,
    String gender,
    String email,
    NameCommand name,
    AccountProfileCommand profile,
    ProviderKeyCommand key
) {

    public Account toDomainModel() {
        return Account.withOutId(birthDate, Gender.from(gender), Email.from(email),
            name.toDomainModel(), AccountRole.GENERAL_USER, profile.toDomainModel(),
            key.toDomainModel());
    }
}
