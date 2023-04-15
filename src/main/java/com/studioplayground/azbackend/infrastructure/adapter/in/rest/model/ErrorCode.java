package com.studioplayground.azbackend.infrastructure.adapter.in.rest.model;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ErrorCode {
    UNKNOWN_ERROR(9999, "Unknown Error")
    ;

    private final int code;
    private final String message;
}
