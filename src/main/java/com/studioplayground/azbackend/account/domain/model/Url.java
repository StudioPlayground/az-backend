package com.studioplayground.azbackend.account.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Url(
        @JsonProperty("url") String url
) {
}
