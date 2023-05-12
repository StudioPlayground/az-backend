package com.studioplayground.azbackend.account.domain.model;

import static com.studioplayground.azbackend.account.domain.model.AccountStatus.ACTIVE;
import static com.studioplayground.azbackend.account.domain.model.AccountStatus.SUSPEND;
import static lombok.AccessLevel.PRIVATE;

import com.studioplayground.azbackend.common.domain.model.Email;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor(access = PRIVATE)
public final class Account {

    private final AccountId id;
    private final LocalDate birthDate;
    private final Gender gender;
    private final Email email;
    // 추가로 필요
    private final Name name;
    private AccountStatus status;
    private final AccountRole role;

    private AccountProfile profile;

    // 추가로 필요
    private final ProviderKey key;


    void suspend() {
        this.status = SUSPEND;
    }

    void unSuspend() {
        this.status = ACTIVE;
    }

    void updateProfile(AccountProfile profile) {
        this.profile = profile;
    }

    public static Account withId(AccountId id, LocalDate birthDate, Gender gender, Email email,
        Name name, AccountStatus status, AccountRole role, AccountProfile profile,
        ProviderKey key) {
        return new Account(
            id,
            birthDate,
            gender,
            email,
            name,
            status,
            role,
            profile,
            key
        );
    }

    public static Account withOutId(LocalDate birthDate, Gender gender, Email email,
        Name name, AccountRole role, AccountProfile profile,
        ProviderKey key) {
        return new Account(
            AccountId.EMPTY,
            birthDate,
            gender,
            email,
            name,
            ACTIVE,
            role,
            profile,
            key
        );
    }
}
