package com.studioplayground.azbackend.infrastructure.adapter.in.rest.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(access = AccessLevel.PRIVATE)
public class FailResponse implements ApiResponse {
    private static final FailResponse EMPTY_FAIL_RESPONSE = of(ErrorCode.UNKNOWN_ERROR, "");

    private final String apiVersion;
    private final boolean success = false;

    private final ErrorCode errorCode;
    private final String message;

    public static FailResponse of(ErrorCode errorCode, String message) {
        return FailResponse.builder()
            .apiVersion("1.0.0")
            .errorCode(errorCode)
            .message(message)
            .build();
    }

    public static FailResponse fail() {
        return EMPTY_FAIL_RESPONSE;
    }
}
