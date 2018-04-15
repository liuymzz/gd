package com.lym.gd.service;

import com.lym.gd.entity.Course;
import com.lym.gd.entity.CourseAttachment;
import com.lym.gd.repository.CourseAttachmentRepository;
import com.lym.gd.repository.CourseRepository;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author liuyaming
 * @date 2018/4/8 下午8:02
 */
@Service
public class TeacherService {

  @Autowired private CourseRepository courseRepository;

  @Autowired private CourseAttachmentRepository courseAttachmentRepository;

  @Transactional
  public boolean addCourse(Course course, CourseAttachment courseAttachment) {

    courseRepository.save(course);

    if (StringUtils.isNotEmpty(courseAttachment.getCourseAttachmentId())) {

      courseAttachmentRepository.save(courseAttachment);
    }

    return true;
  }
}
