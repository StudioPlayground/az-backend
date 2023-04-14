package com.studioplayground.azbackend.account.domain.model;

import com.studioplayground.azbackend.common.domain.model.Url;
import java.util.List;

public record AccountProfile(
    ProfileNickname nickname,
    Url profileImageUrl,

    // 여기 Purpose 가 있는게 맞나?
    List<Purpose> interestPurposeList
) {

    static class Purpose {

    }
}
