package com.lym.gd.mapper;

import com.lym.gd.DTO.CheckWorkDTO;
import com.lym.gd.DTO.UserWorkCourseDTO;
import com.lym.gd.entity.Work;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liuyaming
 * @date 2018/4/22 下午2:44
 */
public interface WorkMapper {

    /**
     * 获取指定学生未完成的作业
     * @param studentId 学生id
     * @return
     */
    List<UserWorkCourseDTO> getNormalWorkByStudent(@Param("studentId") String studentId);

    /**
     * 获取所属课程状态为正在进行的作业
     * @param workId 作业id
     * @return 作业
     */
    Work getNormalWorkByWorkId(@Param("workId") String workId);

    /**
     * 老师批改作业界面，获取已提交作业的学生列表
     * @param workId
     * @return
     */
    List<CheckWorkDTO> getUserAndStudentWorkByWorkId(@Param("workId") String workId);
}
