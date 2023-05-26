package com.studioplayground.azbackend.account.application.port.in;

import com.studioplayground.azbackend.account.domain.model.aggregate.Account;

public interface ReadAccountUseCase {

    Account get(String email);
}
