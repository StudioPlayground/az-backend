package com.studioplayground.azbackend.common.domain.model;

import java.util.Objects;

public record Email(String email) {

    // Email validation 을 여기서도 해야되나
    // 한다면 어떤 형식으로 해야하나
    public Email {
        // null 체크는 어떻게
        Objects.requireNonNull(email);
    }

    public static Email from(String email) {
        return new Email(email);
    }

}
