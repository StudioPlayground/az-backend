package com.studioplayground.azbackend.account.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Email(
        @JsonProperty("email") String email
) {
}
