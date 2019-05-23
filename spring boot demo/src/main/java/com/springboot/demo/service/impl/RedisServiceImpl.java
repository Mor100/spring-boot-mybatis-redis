package com.springboot.demo.service.impl;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.springboot.demo.service.RedisService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private RedisTemplate redisTemplate;

    private Logger logger;

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

    @Override
    public void init(String password) {
        Jedis jedis = new Jedis("123456");
//        logger.log(Level.INFO,"连接成功");
        System.out.println("连接成功");
    }
}
