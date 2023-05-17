package com.studioplayground.azbackend.account.domain.model;

import static java.util.stream.Collectors.toUnmodifiableMap;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

public enum AccountStatus {
    SUSPEND, ACTIVE;

    private static final Map<String, AccountStatus> STATUS_MAP = Arrays.stream(values())
        .collect(toUnmodifiableMap(AccountStatus::name, status -> status));

    public static AccountStatus from(String status) {
        return Objects.requireNonNull(
            STATUS_MAP.get(status),
            () -> "해당하는 AccountStatus 를 찾을 수 없습니다 [status=" + status + "]"
        );
    }
}
