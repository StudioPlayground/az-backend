package com.studioplayground.azbackend.account.application.port.out;

import com.studioplayground.azbackend.account.domain.model.AccountId;

public interface DeleteAccountPort {
    AccountId delete();
}
