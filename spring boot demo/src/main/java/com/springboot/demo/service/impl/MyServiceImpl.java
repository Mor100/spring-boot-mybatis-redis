package com.springboot.demo.service.impl;

import com.springboot.demo.dao.MyMapper;
import com.springboot.demo.entity.User;
import com.springboot.demo.service.MyService;
import com.springboot.demo.service.RedisService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MyServiceImpl implements MyService {

    @Resource
    private MyMapper myMapper;

    @Resource
    private RedisService redisService;

    @Override
    public User getFromRedis(String key) {
        User user = myMapper.select().get(0);
        if (redisService.isExist(key)){
            return (User) redisService.get(key);
        }
        setToRedis(key,user);
        return user;
    }

    @Override
    public void setToRedis(String key,Object value) {
        boolean isExist = redisService.isExist(key);
        if (!isExist){
            redisService.set(key,value);
        }
    }
}
