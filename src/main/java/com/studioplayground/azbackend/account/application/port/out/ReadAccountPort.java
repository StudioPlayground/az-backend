package com.studioplayground.azbackend.account.application.port.out;

import com.studioplayground.azbackend.account.domain.model.aggregate.Account;
import com.studioplayground.azbackend.account.domain.model.aggregate.Email;

public interface ReadAccountPort {

    Account get(Email email);
}
