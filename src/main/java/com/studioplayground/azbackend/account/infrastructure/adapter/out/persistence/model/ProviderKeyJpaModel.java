package com.studioplayground.azbackend.account.infrastructure.adapter.out.persistence.model;

import static lombok.AccessLevel.PRIVATE;

import com.studioplayground.azbackend.account.domain.model.ProviderKey;
import com.studioplayground.azbackend.account.domain.model.ProviderKey.ProviderId;
import com.studioplayground.azbackend.account.domain.model.ProviderKey.ProviderType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = PRIVATE)
public class ProviderKeyJpaModel {

    @Column(name = "providerType")
    private String type;

    @Column(name = "providerId")
    private String id;

    public static ProviderKeyJpaModel from(ProviderKey key) {
        return new ProviderKeyJpaModel(key.type().name(), key.id().id());
    }

    public ProviderKey toDomainModel() {
        return new ProviderKey(ProviderType.from(type), new ProviderId(id));
    }

}
