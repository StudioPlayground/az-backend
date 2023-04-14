package com.studioplayground.azbackend.account.domain.model;

import static lombok.AccessLevel.PRIVATE;

import com.studioplayground.azbackend.common.domain.model.Email;
import lombok.AllArgsConstructor;
import lombok.Value;

@AllArgsConstructor(access = PRIVATE)
@Value
public class PendingAccount implements Accountable {

    AccountId id;
    Name name;
    AccountRole role;
    ProviderKey key;
    Email email;


    @Override
    public AccountStatus getStatus() {
        return AccountStatus.PENDING;
    }

    public static PendingAccount withOutId(
        Name name,
        Email email,
        AccountRole role,
        ProviderKey key
    ) {
        return new PendingAccount(AccountId.EMPTY, name, role, key, email);
    }
}
