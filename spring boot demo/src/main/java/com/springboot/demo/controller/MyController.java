package com.springboot.demo.controller;

import com.springboot.demo.entity.User;
import com.springboot.demo.service.MyService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class MyController {

    @Resource
    private MyService myService;

    @RequestMapping(value = "/")
    public User get(){
        User user = myService.getFromRedis("user");

        return user;
    }
}
