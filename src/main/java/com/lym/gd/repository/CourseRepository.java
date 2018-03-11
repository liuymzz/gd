package com.lym.gd.repository;

import com.lym.gd.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author liuyaming
 * @date 2018/3/11 下午6:03
 */
public interface CourseRepository extends JpaRepository<Course,String>{
}
