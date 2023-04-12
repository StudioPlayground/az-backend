package com.studioplayground.azbackend.account.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AccountId (
        @JsonProperty("id") Long id
) {
    public boolean isNull() {
        return id == null;
    }
}
