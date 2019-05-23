package com.springboot.demo.controller;

import com.springboot.demo.entity.User;
import com.springboot.demo.service.MyService;
import com.springboot.demo.service.RedisService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@RestController
public class MyController {

    @Resource
    private MyService myService;

    @Resource
    private RedisService redisService;

    @RequestMapping(value = "/")
    public User get(){
//        redisService.init("123456");
        User user;
        boolean isExit = redisService.isExist("user");
        user = myService.getFirstUser();
        if (isExit){
            user = (User) redisService.get("user");
        }
        return user;
    }

    @RequestMapping(value = "/index")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("username","zhangsan");
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
