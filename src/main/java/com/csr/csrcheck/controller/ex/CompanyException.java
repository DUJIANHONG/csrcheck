package com.csr.csrcheck.controller.ex;

import com.csr.csrcheck.service.ex.ServiceException;

/**
 * @description:数据不存在没有数据
 * @author: Administrator
 * @date: Created in 2019/10/18 9:14
 * @version:
 * @modified By:
 */
public class CompanyException extends RuntimeException {
    public CompanyException() {
    }

    public CompanyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public CompanyException(String message, Throwable cause) {
        super(message, cause);
    }

    public CompanyException(String message) {
        super(message);
    }

    public CompanyException(Throwable cause) {
        super(cause);
    }
}
