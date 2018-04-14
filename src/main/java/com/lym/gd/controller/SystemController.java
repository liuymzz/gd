package com.lym.gd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author liuyaming
 * @date 2018/4/14 下午12:39
 */
@Controller
public class SystemController {

    @GetMapping("/404")
    public String notFindView(){
        return "other/404";
    }

}
