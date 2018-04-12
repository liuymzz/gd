package com.lym.gd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author liuyaming
 * @date 2018/4/12 下午5:11
 */

@Controller
public class ChatController {

    @GetMapping("/chat")
    public String chatView(){

        return "other/chat";
    }

}
