package com.lym.gd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author liuyaming
 * @date 2018/4/9 上午11:04
 */

@Controller
public class FunctionController {

    @GetMapping("/interact")
    public String interactView(String name){
        return "other/interact";
    }
}
