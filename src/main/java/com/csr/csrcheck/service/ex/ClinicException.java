package com.csr.csrcheck.service.ex;

/**
 * 临床数据异常
 */
public class ClinicException extends RuntimeException{
    public ClinicException() {
    }

    public ClinicException(String message) {
        super(message);
    }

    public ClinicException(String message, Throwable cause) {
        super(message, cause);
    }

    public ClinicException(Throwable cause) {
        super(cause);
    }

    public ClinicException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
