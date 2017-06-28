package com.wish.action.common.exception;

/**
 * 应用系统级别的错误码
 * Created by fqh on 17/6/24.
 */
public enum ActionErrorInfoEnum implements ErrorInfoInterface{

    SUCCESS("0", "success"),
    NOT_FOUND("-1", "service not found");

    private String code;

    private String message;

    ActionErrorInfoEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode(){
        return this.code;
    }

    public String getMessage(){
        return this.message;
    }
}
