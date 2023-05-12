package com.studioplayground.azbackend.account.infrastructure.adapter.in.rest.model;


import com.studioplayground.azbackend.account.domain.model.AccountProfile;

public record AccountProfileResponseDto(String nickname, String profileImageUrl) {
    public static AccountProfileResponseDto from(AccountProfile profile) {
        return new AccountProfileResponseDto(profile.nickname().nickname(), profile.profileImageUrl().url());
    }
}
