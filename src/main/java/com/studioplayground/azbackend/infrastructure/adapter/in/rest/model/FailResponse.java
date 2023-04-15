package com.studioplayground.azbackend.infrastructure.adapter.in.rest.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(access = AccessLevel.PRIVATE)
public non-sealed abstract class FailResponse implements ApiResponse {
    private final String apiVersion;
    private final boolean success = false;

    private final ErrorCode errorCode;
    private final String message;

    public static FailResponse of(ErrorCode errorCode, String message) {
        return FailResponse.builder()
            .apiVersion(DEFAULT_API_VERSION)
            .errorCode(errorCode)
            .message(message)
            .build();
    }
}
