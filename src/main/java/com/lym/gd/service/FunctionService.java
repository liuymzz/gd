package com.lym.gd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * @author liuyaming
 * @date 2018/4/9 上午11:04
 */

@Service
public class FunctionService {
    @Autowired
    private HttpSession httpSession;

    public String sessionId(){
        return httpSession.getId();
    }


}
