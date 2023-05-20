package com.studioplayground.azbackend.common.infrastructure.adapter.in.rest.model;

public sealed interface ApiResponse permits SuccessResponse, FailResponse {
    String DEFAULT_API_VERSION = "1.0.0";

    String getApiVersion();
    String getDomain();
    boolean isSuccess();
}
