package com.lym.gd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author liuyaming
 * @date 2018/3/15 下午10:08
 */
@Controller
public class TeacherController {

    @GetMapping("/course")
    public String courseView(){

        return "other/addCourse";
    }

}
