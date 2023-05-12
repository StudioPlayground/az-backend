package com.studioplayground.azbackend.account.infrastructure.adapter.in.rest.model;

import static lombok.AccessLevel.PROTECTED;

import com.studioplayground.azbackend.account.domain.model.ProviderKey;
import com.studioplayground.azbackend.account.domain.model.ProviderKey.ProviderId;
import com.studioplayground.azbackend.account.domain.model.ProviderKey.ProviderType;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = PROTECTED)
public class ProviderKeyRequestDto {

    private ProviderType type;
    private String id;

    public ProviderKey toProviderKey() {
        return new ProviderKey(type, new ProviderId(id));
    }
}
