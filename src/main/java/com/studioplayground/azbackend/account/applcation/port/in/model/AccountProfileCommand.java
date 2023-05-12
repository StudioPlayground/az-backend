package com.studioplayground.azbackend.account.applcation.port.in.model;

import com.studioplayground.azbackend.account.domain.model.ProfileNickname;
import com.studioplayground.azbackend.common.domain.model.Url;

public record AccountProfileCommand(
    ProfileNickname nickname,
    Url profileImageUrl
) {

}
