package com.springboot.demo.service;

import com.springboot.demo.entity.User;

public interface MyService {
    User getFromRedis(String key);
    void setToRedis(String key,Object value);
}
