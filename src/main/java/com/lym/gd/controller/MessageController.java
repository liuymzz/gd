package com.lym.gd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author liuyaming
 * @date 2018/3/11 下午11:10
 */
@Controller
public class MessageController {

    @GetMapping("/message")
    public String message(){

        return "user/message";
    }

}
