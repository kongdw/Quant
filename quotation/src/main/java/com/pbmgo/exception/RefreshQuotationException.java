package com.pbmgo.exception;

/**
 * 刷新行情异常
 * @author David Kong
 * @date 2016/11/7.
 */
public class RefreshQuotationException extends RuntimeException {
    private static final long serialVersionUID = -956286851808882812L;

    public RefreshQuotationException() {
        super();
    }

    public RefreshQuotationException(String message) {
        super(message);
    }

    public RefreshQuotationException(String message, Throwable cause) {
        super(message, cause);
    }

    public RefreshQuotationException(Throwable cause) {
        super(cause);
    }
}
