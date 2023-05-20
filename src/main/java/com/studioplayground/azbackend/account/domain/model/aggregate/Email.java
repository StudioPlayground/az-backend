package com.studioplayground.azbackend.account.domain.model.aggregate;

public record Email(
        String email
) {
    public static Email from(String email) {
        return new Email(email);
    }
}
