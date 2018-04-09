package com.lym.gd.controller;

import com.alibaba.fastjson.JSONObject;
import com.lym.gd.DTO.CourseDTO;
import com.lym.gd.entity.Course;
import com.lym.gd.entity.CourseAttachment;
import com.lym.gd.entity.User;
import com.lym.gd.service.TeacherService;
import com.lym.gd.utils.IdUtils;
import com.lym.gd.utils.ResultVOUtil;
import com.lym.gd.vo.ResultVO;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author liuyaming
 * @date 2018/3/15 下午10:08
 */
@Controller
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/course")
    public String courseView(){

        return "other/addCourse";
    }

    @PostMapping("/course")
    @ResponseBody
    public ResultVO addCourse(@RequestBody JSONObject jsonObject, HttpServletRequest request){
        Course course = JSONObject.parseObject(jsonObject.toJSONString(),Course.class);
        CourseAttachment courseAttachment = JSONObject.parseObject(jsonObject.toJSONString(),CourseAttachment.class);

        User user = (User) request.getSession().getAttribute("user");
        // 填充course属性
        course.setCourseId(IdUtils.getCourseId());
        course.setCourseTeacherId(user.getUserId());

        if (StringUtils.isNotEmpty(courseAttachment.getCourseAttachmentUrl())) {
          // 填充courseAttachment属性
          courseAttachment.setCourseId(course.getCourseId());
          courseAttachment.setCourseAttachmentId(IdUtils.getCourseAttachmentId());
          String attachmentURL = courseAttachment.getCourseAttachmentUrl();
          String attachmentName = attachmentURL.substring(attachmentURL.indexOf("###") + 3);
          courseAttachment.setCourseAttachmentName(attachmentName);
        }

        System.out.println(course);
        System.out.println(courseAttachment);

        teacherService.addCourse(course,courseAttachment);

        ResultVO resultVO = ResultVOUtil.success();
        resultVO.setMessage("发布成功");
        return resultVO;
    }

}
