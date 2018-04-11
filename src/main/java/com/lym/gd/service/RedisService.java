package com.lym.gd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
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

    /**
     * 删除指定前缀的键值对
     * @param prefix 前缀
     */
    public void deleteByPrefix(String prefix){
        // 根据前缀获取所有匹配的上的键
        Set<String> keys = stringRedisTemplate.keys(prefix + "*");

        stringRedisTemplate.delete(keys);


    }

    /**
     * 根据前缀查找所有能匹配的上的键值对
     *
     * @param prefix 前缀
     * @return 键值对集合
     */
    public Map<String,String> getByPrefix(String prefix){
        Map<String,String> result = new HashMap<>();

        Set<String> keys = stringRedisTemplate.keys(prefix + "*");

        keys.forEach(key->result.put(key,stringRedisTemplate.opsForValue().get(key)));

        return result;
    }

}
