package com.springboot.demo.service;

public interface RedisService {
    void set(String key,Object value);
    Object get(String key);
    boolean remove(String key);
    boolean isExist(String key);
    void init(String password);
}
