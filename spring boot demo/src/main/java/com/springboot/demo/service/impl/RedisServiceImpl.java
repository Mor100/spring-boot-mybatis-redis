package com.springboot.demo.service.impl;

import com.springboot.demo.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void set(String key, Object value) {
        ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
        valueOperations.set(key,value);
    }

    @Override
    public Object get(String key) {
        ValueOperations<String,Object> valueOperations = redisTemplate.opsForValue();
        return valueOperations.get(key);
    }

    @Override
    public boolean remove(String key) {
        redisTemplate.delete(key);
        return false;
    }

    @Override
    public boolean isExist(String key) {
        if (redisTemplate.hasKey(key))
            return true;
        return false;
    }
}
