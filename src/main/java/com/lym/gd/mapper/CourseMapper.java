package com.lym.gd.mapper;

import com.lym.gd.DTO.CourseAndUserDTO;

import java.util.List;

/**
 * @author liuyaming
 * @date 2018/4/26 下午2:46
 */
public interface CourseMapper {

    List<CourseAndUserDTO> findCourseAndUserByCourseStatus(String status);

}
