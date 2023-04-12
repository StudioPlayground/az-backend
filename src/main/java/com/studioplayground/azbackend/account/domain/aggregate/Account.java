package com.studioplayground.azbackend.account.domain.aggregate;

import com.studioplayground.azbackend.account.domain.model.*;
import lombok.AllArgsConstructor;

import java.time.Clock;
import java.time.LocalDate;

@AllArgsConstructor
public class Account {
    private final AccountId id;
    private final LocalDate birthDate;
    private final Gender gender;
    private final Email email;
    private final AccountRole role;

    private AccountProfile profile;
    private AccountStatus status;

    public void suspend() {
        this.status = AccountStatus.SUSPEND;
    }

    public void unSuspend() {
        this.status = AccountStatus.ACTIVE;
    }

    public void updateProfile(AccountProfile profile) {
        this.profile = profile;
    }

    public int getAge() {
        return getAge(Clock.systemDefaultZone());
    }

    public int getAge(Clock clock) {
        final LocalDate nowDate = LocalDate.now(clock);
        final int yearAge = nowDate.getYear() - birthDate.getYear();

        return nowDate.minusYears(yearAge).isBefore(birthDate)
                ? yearAge - 1
                : yearAge;
    }
}
