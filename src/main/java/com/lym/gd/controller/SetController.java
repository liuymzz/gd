package com.lym.gd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author liuyaming
 * @date 2018/3/11 下午10:56
 */
@Controller
public class SetController {

    @GetMapping("/set")
    public String set(){

        return "user/set";
    }

}
