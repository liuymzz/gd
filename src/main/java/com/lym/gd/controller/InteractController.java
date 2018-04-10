package com.lym.gd.controller;

import com.lym.gd.service.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author liuyaming
 * @date 2018/4/10 下午3:32
 */
@Controller
public class InteractController {
    @Autowired
    private FunctionService functionService;

    @GetMapping("/interact")
    public String interactView(String name){
        return "other/interact";
    }

    @GetMapping("/getSessionId")
    @ResponseBody
    public String getSessionId(){
        return functionService.sessionId();
    }

}
