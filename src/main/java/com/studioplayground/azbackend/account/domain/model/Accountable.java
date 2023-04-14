package com.studioplayground.azbackend.account.domain.model;

import com.studioplayground.azbackend.common.domain.model.Email;

public sealed interface Accountable permits Account, PendingAccount {
    AccountId getId();
    Name getName();
    AccountStatus getStatus();
    AccountRole getRole();
    ProviderKey getKey();
    Email getEmail();
}
