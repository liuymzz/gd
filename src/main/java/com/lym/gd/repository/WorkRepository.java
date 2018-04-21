package com.lym.gd.repository;

import com.lym.gd.entity.Work;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author liuyaming
 * @date 2018/3/11 下午6:17
 */
public interface WorkRepository extends JpaRepository<Work,String> {

    /**
     * 根据课程Id以及作业状态查询
     * @param courseId
     * @param workStatus
     * @return
     */
    List<Work> findByCourseIdAndWorkStatus(String courseId,String workStatus);

}
