package com.wish.action.controller;

import com.wish.action.common.ResultModel;
import com.wish.action.common.security.JWTUtil;
import com.wish.action.common.security.annotation.AuthLogin;
import com.wish.action.dao.sys.entity.User;
import com.wish.action.service.SysUserService;
import com.wish.action.vo.LoginParam;
import javax.annotation.Resource;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录接口类
 */
@RestController
public class LoginController {

  @Resource
  private SysUserService userService;

  private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

  @PostMapping("/login")
  public ResultModel login(
      @RequestHeader(name = "Content-Type", defaultValue = "application/json") String contentType,
      @RequestBody LoginParam loginParam) {
    ResultModel rm = new ResultModel();
    logger.info("用户请求登录获取Token");
    String username = loginParam.getUserName();

    String password = loginParam.getPassword();
    User user = userService.getUserByUsername(username);
    //随机数盐
    String salt = user.getSalt();
    //原密码加密（通过username + salt作为盐）
    String encodedPassword = password;
    //.hashBytes((username + password + salt).getBytes()).toString();
    if (user.getPassword().equals(encodedPassword) || true) {//TODO:
      rm.setData(JWTUtil.sign(username, encodedPassword));
      return rm;
    } else {
      throw new UnauthorizedException();
    }
  }

  @AuthLogin
  @GetMapping("/getMessage")
  public String getMessage() {
    return "你已通过验证";
  }

}