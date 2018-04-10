package com.lym.gd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author liuyaming
 * @date 2018/4/10 下午2:27
 */
@Service
public class RedisService {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 向Redis中添加一个值
     * @param key 键
     * @param value 值
     * @param time 超时时间,单位为分钟
     */
    public void add(String key,String value,long time){
        stringRedisTemplate.opsForValue().set(key,value,time,TimeUnit.MINUTES);
    }

    /**
     * 从Redis中获取值
     * @param key 键
     * @return 键对应的值
     */
    public String get(String key){
        return stringRedisTemplate.opsForValue().get(key);
    }

    /**
     *
     * 向Redis中添加一个值，不设置过期时间
     *
     * @param key 键
     * @param value 值
     */
    public void setNoTime(String key,String value){
        stringRedisTemplate.opsForValue().set(key,value);
    }

    /**
     * 删除对应键值对
     * @param key 键
     */
    public void remove(String key){
        stringRedisTemplate.delete(key);
    }

}
