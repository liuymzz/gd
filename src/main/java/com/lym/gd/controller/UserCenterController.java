package com.lym.gd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author liuyaming
 * @date 2018/3/11 下午9:21
 */
@Controller
public class UserCenterController {

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("hello","hello");
        return "user/index";
    }

}
