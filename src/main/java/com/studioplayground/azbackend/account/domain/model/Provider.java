package com.studioplayground.azbackend.account.domain.model;

import static java.util.stream.Collectors.toUnmodifiableMap;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

public enum Provider {
    GOOGLE;

    private static final Map<String, Provider> PROVIDER_MAP = Arrays.stream(values())
        .collect(toUnmodifiableMap(Provider::name, provider -> provider));

    public Provider from(String provider) {
        return Objects.requireNonNull(PROVIDER_MAP.get(provider),
            () -> "해당하는 Provider 가 없습니다. [provider=" + provider + "]");
    }
}
