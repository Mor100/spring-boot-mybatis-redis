package com.springboot.demo.service.impl;

import com.springboot.demo.dao.MyMapper;
import com.springboot.demo.entity.User;
import com.springboot.demo.service.MyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MyServiceImpl implements MyService {

    @Resource
    private MyMapper myMapper;

    @Override
    public User getFirstUser() {
        return myMapper.select().get(0);
    }
}
