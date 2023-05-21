package com.studioplayground.azbackend.account.domain.model.aggregate;

public record ProfileNickName(String nickName) {
    public static ProfileNickName from(String nickName) {
        return new ProfileNickName(nickName);
    }
}
