package com.studioplayground.azbackend.account.domain.model.aggregate;

import static lombok.AccessLevel.PRIVATE;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(access = PRIVATE)
public class Account {
    private AccountId id;
    private LocalDate birthDate;
    private Gender gender;
    private Email email;
    private String name;
    private AccountProfile profile;
    private AccountStatus status;
    private AccountRole role;

    public void suspend() {}
    public void unsuspend() {}
    public void updateProfile() {}

    public Integer getAge() {
        return Integer.getInteger(birthDate.format(DateTimeFormatter.ofPattern("yyyy")));
    }

    public static Account withId(AccountId id, LocalDate birthDate, Gender gender, Email email,
                                   String name, AccountStatus status, AccountRole role, AccountProfile profile) {

        return Account.builder().id(id).birthDate(birthDate).gender(gender).email(email)
                .name(name).profile(profile).status(status).role(role)
                .build();
    }

    public static Account withOutId(LocalDate birthDate, Gender gender, Email email,
                                 String name, AccountStatus status, AccountRole role, AccountProfile profile) {

        return Account.builder().id(AccountId.EMPTY).birthDate(birthDate).gender(gender)
                .email(email).name(name).profile(profile).status(status).role(role)
                .build();
    }

}
