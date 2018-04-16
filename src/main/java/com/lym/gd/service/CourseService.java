package com.lym.gd.service;

import com.lym.gd.DTO.CourseAndUserDTO;
import com.lym.gd.entity.Course;
import com.lym.gd.entity.User;
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

    ;


}
