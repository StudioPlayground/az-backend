package com.studioplayground.azbackend.account.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AccountProfile(
        @JsonProperty("nickname") ProfileNickname nickname
        , @JsonProperty("profileImageUrl") Url profileImageUrl
        // , @JsonProperty("interestPurposeList") List<Purpose> interestPurposeList
) {
}
