package com.studioplayground.azbackend.account.domain.model.aggregate;

public record AccountProfile(ProfileNickName profileNickName, Url profileUrl) {
    public static AccountProfile from(String profileNickName, String profileUrl) {
        return new AccountProfile(ProfileNickName.from(profileNickName), Url.from(profileUrl));
    }
}
