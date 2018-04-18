package com.lym.gd.repository;

import com.lym.gd.entity.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author liuyaming
 * @date 2018/3/11 下午6:12
 */
public interface StudentCourseRepository extends JpaRepository<StudentCourse,String> {

    StudentCourse findByCourseIdAndStudentId(String courseId,String studentId);

}
