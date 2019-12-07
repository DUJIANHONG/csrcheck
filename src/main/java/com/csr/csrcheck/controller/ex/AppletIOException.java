package com.csr.csrcheck.controller.ex;

/**
 * @author Karry
 * @create 2019-11-20 14:51
 */
public class AppletIOException extends RuntimeException{
    public AppletIOException() {
    }

    public AppletIOException(String message) {
        super(message);
    }

    public AppletIOException(String message, Throwable cause) {
        super(message, cause);
    }

    public AppletIOException(Throwable cause) {
        super(cause);
    }

    public AppletIOException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
