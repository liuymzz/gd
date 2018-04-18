package com.lym.gd.service;

import com.alibaba.fastjson.JSONObject;
import com.lym.gd.DTO.CourseAndUserDTO;
import com.lym.gd.DTO.CourseDetailDTO;
import com.lym.gd.entity.Course;
import com.lym.gd.entity.CourseAttachment;
import com.lym.gd.entity.StudentCourse;
import com.lym.gd.entity.User;
import com.lym.gd.enums.CourseEnum;
import com.lym.gd.repository.CourseAttachmentRepository;
import com.lym.gd.repository.CourseRepository;
import com.lym.gd.repository.StudentCourseRepository;
import com.lym.gd.repository.UserRepository;
import com.lym.gd.utils.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author liuyaming
 * @date 2018/4/16 下午1:19
 */
@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseAttachmentRepository courseAttachmentRepository;

    @Autowired
    private StudentCourseRepository studentCourseRepository;

    @Autowired
    private HttpSession httpSession;

    /**
     * 根据课程状态查找
     * @param status
     * @return
     */
    public List<CourseAndUserDTO> findCourseByCourseStatus(String status) {
        List<CourseAndUserDTO> courseAndUserDTOS = new ArrayList<>();

        List<Course> courses = courseRepository.findByCourseStatus(status);

        courses.forEach(course -> {
            CourseAndUserDTO courseAndUserDTO = new CourseAndUserDTO();
            courseAndUserDTO.setCourse(course);
            User user = userRepository.findByUserId(course.getCourseTeacherId());
            courseAndUserDTO.setUser(user);
            courseAndUserDTOS.add(courseAndUserDTO);
        });

        return courseAndUserDTOS;
    }

    /**
     * 获取进入课程详细界面所需要的一些数据
     * @param courseId
     * @return
     */
    public CourseDetailDTO getCourseDetail(String courseId){
        CourseDetailDTO courseDetailDTO = new CourseDetailDTO();

        Course course = courseRepository.findByCourseId(courseId);
        User user = userRepository.findByUserId(course.getCourseTeacherId());
        CourseAttachment courseAttachment = courseAttachmentRepository.findByCourseId(courseId);

        // 存在数据库中的文件url中存在有“#”特殊符号，需要进行转义
        if (courseAttachment != null) {
            courseAttachment.setCourseAttachmentUrl(courseAttachment.getCourseAttachmentUrl().replace("#", "%23"));
        }

        courseDetailDTO.setCourse(course);
        courseDetailDTO.setUser(user);
        courseDetailDTO.setCourseAttachment(courseAttachment);

        return courseDetailDTO;
    }

    /**
     * 根据给定的课程id匹配当前登录用户进行选课
     * @param courseId
     */
    public void selectCourse(String courseId){
        String userId = IdUtils.getUserId(httpSession);

        StudentCourse studentCourse =
                new StudentCourse.
                        Builder()
                        .studentCourseId(IdUtils.getStudentCourseId())
                        .courseId(courseId)
                        .courseChooseDate(new Date())
                        .studentId(userId)
                        .courseStatus("1")
                        .build();

        studentCourseRepository.save(studentCourse);
    }

    /**
     * 根据courseId查找当前用户是否已选该门课程
     *
     * @param courseId
     * @return 如果已选则返回course对象，否则是空
     */
    public StudentCourse findStudentCourseByCourseIdAndUserId(String courseId) {
        String userId = IdUtils.getUserId(httpSession);

        return studentCourseRepository.findByCourseIdAndStudentId(courseId,userId);
    }

    /**
     * 获取当前用户已经开始并且未结课的所有课程名称
     * @return
     */
    public List<Course> getStartAndNotFinishCourse() {

        String userId = IdUtils.getUserId(httpSession);

        return courseRepository.findCoursesByCourseTeacherIdAndCourseStatus(userId,CourseEnum.STARTING.getStatus());
    }

}
