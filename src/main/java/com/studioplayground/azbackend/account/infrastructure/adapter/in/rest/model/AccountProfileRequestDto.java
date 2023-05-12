package com.studioplayground.azbackend.account.infrastructure.adapter.in.rest.model;

import static lombok.AccessLevel.PROTECTED;

import com.studioplayground.azbackend.account.domain.model.AccountProfile;
import com.studioplayground.azbackend.account.domain.model.ProfileNickname;
import com.studioplayground.azbackend.common.domain.model.Url;
import jakarta.validation.constraints.NotBlank;
import java.util.List;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

@NoArgsConstructor(access = PROTECTED)
public class AccountProfileRequestDto {

    @NotBlank
    private String nickname;

    @URL
    private String profileImageUrl;

    public AccountProfile toProfile() {
        return new AccountProfile(
            new ProfileNickname(nickname),
            new Url(profileImageUrl),
            List.of()
        );
    }

}
