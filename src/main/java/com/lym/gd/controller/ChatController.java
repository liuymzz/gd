package com.lym.gd.controller;

import com.lym.gd.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

/**
 * @author liuyaming
 * @date 2018/4/12 下午5:11
 */

@Controller
@Slf4j
public class ChatController {

    @Autowired
    private RedisService redisService;

    @GetMapping("/chat")
    public String chatView(Model model, String h, HttpServletRequest request){

        String hh = request.getParameter("h");

        Set<String> keys = redisService.getKeysByPrefix(h);

        if (keys.size() > 0) {

            model.addAttribute("channel", h);
        }

        return "other/chat";
    }

}
