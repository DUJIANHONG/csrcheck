package com.csr.csrcheck.service.ex;

public class LawsuitException extends RuntimeException{
    public LawsuitException() {
    }

    public LawsuitException(String message) {
        super(message);
    }

    public LawsuitException(String message, Throwable cause) {
        super(message, cause);
    }

    public LawsuitException(Throwable cause) {
        super(cause);
    }

    public LawsuitException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
