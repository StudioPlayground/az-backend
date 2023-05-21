package com.studioplayground.azbackend.account.infrastructure.adapter.out.persistence.model;

import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

import com.studioplayground.azbackend.account.domain.model.aggregate.AccountProfile;
import com.studioplayground.azbackend.account.domain.model.aggregate.ProfileNickName;
import com.studioplayground.azbackend.account.domain.model.aggregate.Url;

import jakarta.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PRIVATE)
public class AccountProfileJpaEntity {

    private String nickName;
    private String profileImageUrl;

    public static AccountProfileJpaEntity from(AccountProfile accountProfile) {
        return new AccountProfileJpaEntity(
                accountProfile.profileNickName().nickName(), accountProfile.profileUrl().url());
    }

    public AccountProfile toDomainModel() {
        return new AccountProfile(ProfileNickName.from(nickName), Url.from(profileImageUrl));
    }
}
