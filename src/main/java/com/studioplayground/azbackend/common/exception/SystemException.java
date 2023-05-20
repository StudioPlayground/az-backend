package com.studioplayground.azbackend.common.exception;

/**
 * 기타 발생 가능한 시스템 Exception
 */
public final class SystemException extends AzitException {
    public SystemException(Throwable e) {
        super(e);
    }

    public SystemException(Throwable e, String message) {
        super(e, message);
    }
}
