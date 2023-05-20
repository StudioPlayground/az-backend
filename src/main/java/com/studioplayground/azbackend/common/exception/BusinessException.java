package com.studioplayground.azbackend.common.exception;

/**
 * 비즈니스 로직상에서 발생한 Exception
 */
public final class BusinessException extends AzitException {
    public BusinessException(Throwable e) {
        super(e);
    }

    public BusinessException(Throwable e, String message) {
        super(e, message);
    }
}
