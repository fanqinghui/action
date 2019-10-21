package com.wish.action.common.security.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.wish.action.common.security.JWTUtil;
import com.wish.action.common.security.annotation.AuthLogin;
import com.wish.action.common.security.annotation.PassAuthLogin;
import com.wish.action.dao.sys.entity.User;
import com.wish.action.service.SysUserService;
import java.lang.reflect.Method;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class JWTFilter implements HandlerInterceptor {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    SysUserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
        Object handler)
        throws Exception {
        String token = request.getHeader("token");// 从 http 请求头中取出 token
        // 如果不是映射到方法直接通过
        if(!(handler instanceof HandlerMethod)){
            return true;
        }
        HandlerMethod handlerMethod=(HandlerMethod)handler;
        Method method=handlerMethod.getMethod();
        //检查是否有PassAuthLogin注解，有则跳过认证
        if (method.isAnnotationPresent(PassAuthLogin.class)) {
            PassAuthLogin passAuthLogin = method.getAnnotation(PassAuthLogin.class);
            if (passAuthLogin.required()) {
                return true;
            }
        }
        //检查有没有需要用户权限的注解
        if (method.isAnnotationPresent(AuthLogin.class)) {
            AuthLogin userLoginToken = method.getAnnotation(AuthLogin.class);
            if (userLoginToken.required()) {
                // 执行认证
                if (token == null) {
                    throw new RuntimeException("无token，请重新登录");
                }
                // 获取 token 中的 user id
                String userName;
                try {
                    userName = JWT.decode(token).getAudience().get(0);
                } catch (JWTDecodeException j) {
                    throw new RuntimeException("401");
                }
                User user = userService.getUserByUsername(userName);
                if (user == null) {
                    throw new RuntimeException("用户不存在，请重新登录");
                }
                try {
                     JWTUtil.verify(token, userName, user.getPassword());
                } catch (JWTVerificationException e) {
                    throw new RuntimeException("401");
                }
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
        HttpServletResponse httpServletResponse,
        Object o, ModelAndView modelAndView) throws Exception {

    }
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
        HttpServletResponse httpServletResponse,
        Object o, Exception e) throws Exception {
    }
}