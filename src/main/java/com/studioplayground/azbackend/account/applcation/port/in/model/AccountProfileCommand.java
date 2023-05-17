package com.studioplayground.azbackend.account.applcation.port.in.model;

import com.studioplayground.azbackend.account.domain.model.AccountProfile;
import com.studioplayground.azbackend.account.domain.model.ProfileNickname;
import com.studioplayground.azbackend.common.domain.model.Url;
import java.util.List;

public record AccountProfileCommand(
    String nickname,
    String profileImageUrl
) {

    public AccountProfile toDomainModel() {
        return new AccountProfile(
            new ProfileNickname(nickname),
            new Url(profileImageUrl),
            List.of());
    }
}
