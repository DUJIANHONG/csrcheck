package com.csr.csrcheck.service.ex;

public class ApprovalsException extends RuntimeException{
    public ApprovalsException() {
    }

    public ApprovalsException(String message) {
        super(message);
    }

    public ApprovalsException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApprovalsException(Throwable cause) {
        super(cause);
    }

    public ApprovalsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
