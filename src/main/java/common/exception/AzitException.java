package common.exception;

import lombok.Getter;

@Getter
public sealed class AzitException extends RuntimeException permits BusinessException, ExternalApiException, SystemException, ValidationException {
    private static final String INTERNAL_SERVER_ERROR = "INTERNAL SERVER ERROR";
    private final String message;

    public AzitException(Throwable e) {
        super(e);
        this.message = INTERNAL_SERVER_ERROR;
    }

    public AzitException(Throwable e, String message) {
        super(e);
        this.message = message;
    }
}
