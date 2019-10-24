package com.csr.csrcheck.service.ex;

/**
 * 一致性评价异常
 */
public class EvaluateException  extends RuntimeException{
    public EvaluateException() {
    }

    public EvaluateException(String message) {
        super(message);
    }

    public EvaluateException(String message, Throwable cause) {
        super(message, cause);
    }

    public EvaluateException(Throwable cause) {
        super(cause);
    }

    public EvaluateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
