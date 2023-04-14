package com.studioplayground.azbackend.account.domain.model;

import com.studioplayground.azbackend.common.domain.model.Identifier;

public record AccountId(Long id) implements Identifier<Long> {
    public static AccountId EMPTY = new AccountId(null);
}
