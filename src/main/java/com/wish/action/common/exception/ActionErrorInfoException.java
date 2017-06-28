package com.wish.action.common.exception;

/**
 * 统一错误码异常
 *  Created by fqh on 17/6/24.
 */
public class ActionErrorInfoException extends Exception {

    private ErrorInfoInterface errorInfo;

    public ActionErrorInfoException(ErrorInfoInterface errorInfo) {
        this.errorInfo = errorInfo;
    }

    public ErrorInfoInterface getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(ErrorInfoInterface errorInfo) {
        this.errorInfo = errorInfo;
    }
}
