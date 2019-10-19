package com.csr.csrcheck.service.ex;

/**
 * 飞行查询异常
 */
public class Flight_checkException extends RuntimeException{
    public Flight_checkException() {
    }

    public Flight_checkException(String message) {
        super(message);
    }

    public Flight_checkException(String message, Throwable cause) {
        super(message, cause);
    }

    public Flight_checkException(Throwable cause) {
        super(cause);
    }

    public Flight_checkException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
