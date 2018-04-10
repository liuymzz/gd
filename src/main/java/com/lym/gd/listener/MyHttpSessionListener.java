package com.lym.gd.listener;

import com.lym.gd.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author liuyaming
 * @date 2018/4/10 下午3:09
 */
@WebListener
public class MyHttpSessionListener implements HttpSessionListener {

    @Autowired
    private RedisService redisService;

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {

    }
}
