package com.studioplayground.azbackend.account.applcation.port.in.model;

import com.studioplayground.azbackend.account.domain.model.ProviderKey.ProviderId;
import com.studioplayground.azbackend.account.domain.model.ProviderKey.ProviderType;

public record ProviderKeyCommand(
    ProviderType type,
    ProviderId id
) {

}
