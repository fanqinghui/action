package com.wish.action.controller.sys;

import com.wish.action.properties.FastdfsInfo;
import com.wish.action.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 *  启动访问类rest
 *  Created by fqh on 17/6/24.
 */
//@RestController
public class SysUserController {

    @Autowired
    FastdfsInfo info;
    @Autowired
    SysUserService userService;

    @RequestMapping(value = "/sys/user/getUserById/{id}",method = RequestMethod.GET)
    public String getUserById(@PathVariable("id") Long id) {
        return userService.getUserById(id).toString();
    }
}