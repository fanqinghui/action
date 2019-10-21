package com.wish.action.controller.sys;

import com.wish.action.common.security.annotation.AuthLogin;
import com.wish.action.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by fqh on 17/6/24.
 */
@RestController
@RequestMapping("/sys/user/")
public class UserController {

    @Autowired
    SysUserService userService;

    @GetMapping("getUserById/{id}")
    @AuthLogin
    public ModelAndView getUserById(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView("user");
        mv.addObject("user", userService.getUserById(id));
        return mv;
    }
}