package com.studioplayground.azbackend.account.infrastructure.adapter.out.persistence.model;

import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

import com.studioplayground.azbackend.account.domain.model.AccountProfile;
import com.studioplayground.azbackend.account.domain.model.ProfileNickname;
import com.studioplayground.azbackend.common.domain.model.Url;
import jakarta.persistence.Embeddable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PRIVATE)
public class AccountProfileJpaModel {

    private String nickName;

    private String profileImageUrl;

    public static AccountProfileJpaModel from(AccountProfile profile) {
        return new AccountProfileJpaModel(profile.nickname().nickname(),
            profile.profileImageUrl().url());
    }

    public AccountProfile toDomainModel() {
        return new AccountProfile(
            new ProfileNickname(nickName),
            new Url(profileImageUrl),
            List.of());
    }

}
