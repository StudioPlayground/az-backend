package com.studioplayground.azbackend.infrastructure.adapter.in.rest.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(access = AccessLevel.PRIVATE)
public non-sealed abstract class SuccessResponse<T> implements ApiResponse {
    private static final SuccessResponse<Object> EMPTY_SUCCESS_RESPONSE = of(null);

    private final String apiVersion;
    private final boolean success = true;

    private final T result;

    public static <T> SuccessResponse<T> of(final T result) {
        return of(DEFAULT_API_VERSION, result);
    }

    public static <T> SuccessResponse<T> of(final String apiVersion, final T result) {
        return SuccessResponse.<T>builder()
            .apiVersion(apiVersion)
            .result(result)
            .build();
    }

    public static SuccessResponse<Object> success() {
        return EMPTY_SUCCESS_RESPONSE;
    }
}
