package com.lym.gd.service;

import com.lym.gd.DTO.CourseAndUserDTO;
import com.lym.gd.DTO.CourseDetailDTO;
import com.lym.gd.entity.Course;
import com.lym.gd.entity.CourseAttachment;
import com.lym.gd.entity.User;
import com.lym.gd.repository.CourseAttachmentRepository;
import com.lym.gd.repository.CourseRepository;
import com.lym.gd.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        courseAttachment.setCourseAttachmentUrl(courseAttachment.getCourseAttachmentUrl().replace("#","%23"));

        courseDetailDTO.setCourse(course);
        courseDetailDTO.setUser(user);
        courseDetailDTO.setCourseAttachment(courseAttachment);

        return courseDetailDTO;
    }


}
