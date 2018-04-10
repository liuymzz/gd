package com.lym.gd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * @author liuyaming
 * @date 2018/4/10 下午3:32
 */
@Service
public class InteractService {
    @Autowired
    private HttpSession httpSession;

    public String sessionId(){
        return httpSession.getId();
    }



}
