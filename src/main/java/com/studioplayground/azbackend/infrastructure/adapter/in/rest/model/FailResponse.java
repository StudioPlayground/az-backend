package com.studioplayground.azbackend.infrastructure.adapter.in.rest.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(access = AccessLevel.PRIVATE)
public non-sealed abstract class FailResponse implements ApiResponse {

    private final String apiVersion;
    private final ApiErrorCode errorCode;
    private final String message;

    @Override
    public boolean isSuccess() {
        return false;
    }

    public static FailResponse of(ApiErrorCode errorCode, String message) {
        return FailResponse.builder()
            .apiVersion(DEFAULT_API_VERSION)
            .errorCode(errorCode)
            .message(message)
            .build();
    }
}
