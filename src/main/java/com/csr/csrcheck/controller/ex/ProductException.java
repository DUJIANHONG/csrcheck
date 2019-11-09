package com.csr.csrcheck.controller.ex;

/**
 * @description:数据不存在没有数据
 * @author: Administrator
 * @date: Created in 2019/10/18 9:14
 * @version:
 * @modified By:
 */
public class ProductException extends RuntimeException {
    public ProductException() {
    }

    public ProductException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ProductException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductException(String message) {
        super(message);
    }

    public ProductException(Throwable cause) {
        super(cause);
    }
}
