package com.studioplayground.azbackend.account.applcation.port.in.model;

import com.studioplayground.azbackend.account.domain.model.ProviderKey;
import com.studioplayground.azbackend.account.domain.model.ProviderKey.ProviderId;
import com.studioplayground.azbackend.account.domain.model.ProviderKey.ProviderType;

public record ProviderKeyCommand(
    String type,
    String id
) {

    public ProviderKey toDomainModel() {
        return new ProviderKey(ProviderType.from(type), new ProviderId(id));
    }
}
