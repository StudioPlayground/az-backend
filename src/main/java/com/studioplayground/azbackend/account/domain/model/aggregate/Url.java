package com.studioplayground.azbackend.account.domain.model.aggregate;

public record Url(String url) {
    public static Url from(String url) {
        return new Url(url);
    }
}
