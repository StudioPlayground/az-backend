package com.studioplayground.azbackend.account.domain.model;

import static java.util.stream.Collectors.toUnmodifiableMap;

import com.studioplayground.azbackend.common.domain.model.Identifier;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

public record ProviderKey(
    ProviderType type,
    ProviderId id
) {

    public enum ProviderType {
        GOOGLE;

        private static final Map<String, ProviderType> PROVIDER_MAP = Arrays.stream(values())
            .collect(toUnmodifiableMap(ProviderType::name, provider -> provider));

        public static ProviderType from(String provider) {
            return Objects.requireNonNull(PROVIDER_MAP.get(provider),
                () -> "해당하는 Provider 가 없습니다. [provider=" + provider + "]");
        }
    }

    public record ProviderId(
        String id
    ) implements Identifier<String> {

    }
}
