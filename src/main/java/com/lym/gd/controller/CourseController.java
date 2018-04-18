package com.lym.gd.controller;

import com.alibaba.fastjson.JSONObject;
import com.lym.gd.DTO.CourseAndUserDTO;
import com.lym.gd.DTO.CourseDetailDTO;
import com.lym.gd.entity.StudentCourse;
import com.lym.gd.enums.CourseEnum;
import com.lym.gd.service.CourseService;
import com.lym.gd.utils.ResultVOUtil;
import com.lym.gd.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 获取所有未开始的课程
     * @param model
     * @return
     */
    @GetMapping("/lesson")
    public String courseView(Model model){

        // 获取未开始的课程
        List<CourseAndUserDTO> courseAndUserDTOS = courseService.findCourseByCourseStatus(CourseEnum.No_START.getStatus());
        model.addAttribute("courseAndUserDTOS",courseAndUserDTOS);

        System.out.println(JSONObject.toJSONString(courseAndUserDTOS));


        return "other/course";
    }

    /**
     * 课程详情
     * @param courseId 课程id
     * @param model
     * @return
     */
    @GetMapping("/courseDetail/{id}")
    public String courseDetail(@PathVariable("id") String courseId,Model model){

        CourseDetailDTO courseDetailDTO = courseService.getCourseDetail(courseId);
        model.addAttribute("courseDetailDTO",courseDetailDTO);

        return "other/courseDetail";
    }

    @PostMapping("/selectCourse")
    @ResponseBody
    public ResultVO selectCourse(@RequestBody JSONObject jsonObject) {
        ResultVO resultVO = ResultVOUtil.success();

        // 1.判断当前用户是否已选该门课程
        StudentCourse studentCourse = courseService.findStudentCourseByCourseIdAndUserId(jsonObject.getString("courseId"));

        // 2.根据1的结果做出反馈.  若已选,提示用户，否则正常选课
        if (studentCourse != null){
            // 说明已经选了这门课
            resultVO = ResultVOUtil.error("同学，你已经选了这门课啦-_-!!!");
        }else {
            // 正常执行选课操作
            courseService.selectCourse(jsonObject.getString("courseId"));
        }

        return resultVO;
    }
}
