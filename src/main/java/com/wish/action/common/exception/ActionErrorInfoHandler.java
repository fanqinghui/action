package com.wish.action.common.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 统一错误码异常处理
 *  Created by fqh on 17/6/24.
 */
//@ControllerAdvice 和 @ResponseBody 的语义结合。是控制器增强，直接返回对象。这里用于统一拦截异常，然后返回错误码对象体。
@RestControllerAdvice
public class ActionErrorInfoHandler {

    //标记了使用 errorHandlerOverJson() 方法来处理 ActionErrorInfoHandler 异常。
    @ExceptionHandler(value = ActionErrorInfoException.class)
    public ResultBody errorHandler2Json(HttpServletRequest request,
                                           ActionErrorInfoException exception) {
        ErrorInfoInterface errorInfo = exception.getErrorInfo();
        ResultBody result = new ResultBody(errorInfo);
        return result;
    }
}
