package com.studioplayground.azbackend.common.exception;

/**
 * 외부 API 호출중 발생한 Exception
 */
public final class ExternalApiException extends AzitException {
    public ExternalApiException(Throwable e) {
        super(e);
    }

    public ExternalApiException(Throwable e, String message) {
        super(e, message);
    }
}
