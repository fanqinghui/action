package com.wish.action.controller.sys;

import com.wish.action.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by fqh on 17/6/24.
 */
@Controller
@RequestMapping("/sys/user/")
public class UserController {

    @Autowired
    SysUserService userService;

    @RequestMapping(value = "getUserById/{id}", method = RequestMethod.GET)
    public ModelAndView getUserById(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView("user");
        mv.addObject("user", userService.getUserById(id));
        return mv;
    }
}