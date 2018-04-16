package com.lym.gd.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author liuyaming
 * @date 2018/4/16 上午10:19
 */
@Controller
@Slf4j
public class CourseController {

    @GetMapping("/lesson")
    public String courseView(){
        return "other/course";
    }

}
