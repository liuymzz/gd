package com.lym.gd.mapper;

import com.lym.gd.DTO.CourseAndUserDTO;
import com.lym.gd.entity.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liuyaming
 * @date 2018/4/26 下午2:46
 */
public interface CourseMapper {

    List<CourseAndUserDTO> findCourseAndUserByCourseStatus(String status);

    /**
     * 定时任务中将课程状态按照开课时间修改成为进行中
     * @return
     */
    int updateCourseStatus2Starting();

    /**
     * 定时任务中将课程状态按照开课时间修改成为已结束
     * @return
     */
    int updateCourseStatus2End();

    /**
     * 根据开课时间获取课程,时间格式：yyyy-MM-dd
     * @param startDate
     * @return
     */
    List<Course> findCoursesByCourseStartDate(@Param("startDate") String startDate);

}
