package com.lym.gd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

/**
 * @author liuyaming
 * @date 2018/3/12 下午11:20
 */
@Controller
public class IndexController {

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        System.out.println("logout");
        return "redirect:/";
    }

}
