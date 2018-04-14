package com.lym.gd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author liuyaming
 * @date 2018/4/12 下午5:11
 */

@Controller
public class ChatController {

    @GetMapping("/chat")
    public String chatView(Model model, String h, HttpServletRequest request){

        String hh = request.getParameter("h");

        model.addAttribute("channel",h);

        return "other/chat";
    }

}
