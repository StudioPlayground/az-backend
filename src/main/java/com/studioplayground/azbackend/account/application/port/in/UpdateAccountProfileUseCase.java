package com.studioplayground.azbackend.account.application.port.in;

import com.studioplayground.azbackend.account.domain.model.AccountId;
import com.studioplayground.azbackend.account.domain.model.AccountProfile;

public interface UpdateAccountProfileUseCase {
    void updateProfile(AccountId id, AccountProfile profile);
}