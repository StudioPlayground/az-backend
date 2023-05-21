package com.studioplayground.azbackend.common.exception;

/** validate 에서 발생한 Exception */
public final class ValidationException extends AzitException {
    public ValidationException(Throwable e) {
        super(e);
    }

    public ValidationException(Throwable e, String message) {
        super(e, message);
    }
}
