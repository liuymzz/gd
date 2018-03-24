package com.lym.gd.controller;

import com.lym.gd.DTO.CourseDTO;
import com.lym.gd.utils.ResultVOUtil;
import com.lym.gd.vo.ResultVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @PostMapping("/course")
    @ResponseBody
    public ResultVO addCourse(CourseDTO courseDTO){
        System.out.println(courseDTO);
        return ResultVOUtil.success();
    }

}
