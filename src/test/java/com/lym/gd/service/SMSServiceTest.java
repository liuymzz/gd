package com.lym.gd.service;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.lym.gd.DTO.AliSMSDTO;
import com.lym.gd.entity.Course;
import com.lym.gd.entity.StudentCourse;
import com.lym.gd.entity.User;
import com.lym.gd.mapper.CourseMapper;
import com.lym.gd.repository.CourseRepository;
import com.lym.gd.repository.StudentCourseRepository;
import com.lym.gd.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liuyaming
 * @date 2018/5/4 下午12:29
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SMSServiceTest {
    @Value("${ali.SMSSignName}")
    private String aliSMSSignName;

    @Value("${ali.TemplateCode}")
    private String aliTemplateCode;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private StudentCourseRepository studentCourseRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SMSService smsService;


    @Test
    public void test(){
        LocalDate nextDay = LocalDate.now().plusDays(1);

        // 获取即将开课的课程
        List<Course> courses = courseMapper.findCoursesByCourseStartDate(nextDay.toString());

        courses.forEach(course -> {

            List<StudentCourse> studentCourses = studentCourseRepository.findByCourseId(course.getCourseId());

            studentCourses.forEach(studentCourse -> {
                User user = userRepository.findByUserId(studentCourse.getStudentId());

                // 现在得到了想要的信息，可以执行发送短信操作

                AliSMSDTO aliSMSDTO = new AliSMSDTO();
                aliSMSDTO.setPhoneNum(user.getUserPhone());
                aliSMSDTO.setSignName(aliSMSSignName);
                aliSMSDTO.setTemplateCode(aliTemplateCode);

                Map<String,String> templateParam = new HashMap<>();
                templateParam.put("studentName",user.getUserName());
                templateParam.put("courseName",course.getCourseTitle());

                aliSMSDTO.setTemplateParam(JSONObject.toJSONString(templateParam));

                try {
                    SendSmsResponse response = smsService.sendSMS(aliSMSDTO);
                    log.info("课程开课短信通知：{}",response.getMessage());
                } catch (Exception e) {
                    e.printStackTrace();
                    log.error("课程开课通知短信发送失败");
                }
            });
        });
    }
}
