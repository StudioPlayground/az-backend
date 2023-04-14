package com.studioplayground.azbackend.account.domain.model;

import com.studioplayground.azbackend.common.domain.model.Identifier;

public record ProviderKey(
    ProviderType type,
    ProviderId id
) {

    public enum ProviderType {
        GOOGLE,
    }

    public record ProviderId(
        String id
    ) implements Identifier<String> {

    }
}
