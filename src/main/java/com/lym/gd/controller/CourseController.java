package com.lym.gd.controller;

import com.alibaba.fastjson.JSONObject;
import com.lym.gd.DTO.CourseAndUserDTO;
import com.lym.gd.enums.CourseEnum;
import com.lym.gd.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author liuyaming
 * @date 2018/4/16 上午10:19
 */
@Controller
@Slf4j
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/lesson")
    public String courseView(Model model){

        // 获取未开始的课程
        List<CourseAndUserDTO> courseAndUserDTOS = courseService.findCourseByCourseStatus(CourseEnum.No_START.getStatus());
        model.addAttribute("courseAndUserDTOS",courseAndUserDTOS);

        System.out.println(JSONObject.toJSONString(courseAndUserDTOS));


        return "other/course";
    }

}
