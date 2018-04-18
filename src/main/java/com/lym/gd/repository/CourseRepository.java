package com.lym.gd.repository;

import com.lym.gd.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author liuyaming
 * @date 2018/3/11 下午6:03
 */
public interface CourseRepository extends JpaRepository<Course,String>{

    /**
     * 根据课程状态查询
     * 1，未开始
     * 2，进行中
     * 3，已结束
     * @param status
     * @return
     */
    List<Course> findByCourseStatus(String status);

    /**
     * 根据id查找course
     * @param courseId
     * @return
     */
    Course findByCourseId(String courseId);

    /**
     * 根据课程讲师以及状态获取
     *
     * @param courseTeacherId
     * @param courseStatus
     * @return
     */
    List<Course> findCoursesByCourseTeacherIdAndCourseStatus(String courseTeacherId,String courseStatus);

}
