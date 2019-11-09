package com.csr.csrcheck.service.ex;

/**
 * 核心人员关联企业异常
 */
public class Actual_controllerException extends RuntimeException{
    public Actual_controllerException() {
    }

    public Actual_controllerException(String message) {
        super(message);
    }

    public Actual_controllerException(String message, Throwable cause) {
        super(message, cause);
    }

    public Actual_controllerException(Throwable cause) {
        super(cause);
    }

    public Actual_controllerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
