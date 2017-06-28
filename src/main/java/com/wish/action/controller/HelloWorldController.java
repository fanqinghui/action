package com.wish.action.controller;

import com.wish.action.properties.FastdfsInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  启动访问类rest
 *  Created by fqh on 17/6/24.
 */
@RestController
public class HelloWorldController {

    @Autowired
    FastdfsInfo info;

    @RequestMapping("/")
    public String sayHello() {
        return info.toString();
    }
}