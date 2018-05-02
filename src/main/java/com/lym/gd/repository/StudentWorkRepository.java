package com.lym.gd.repository;

import com.lym.gd.entity.StudentWork;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author liuyaming
 * @date 2018/4/27 下午3:25
 */
public interface StudentWorkRepository extends JpaRepository<StudentWork,String> {

    /**
     * 查询用户是否已完成某课程作业
     * @param studentWorkUserId
     * @param workId
     * @return 如果返回null则说明没有完成
     */
    StudentWork findByStudentWorkUserIdAndWorkId(String studentWorkUserId,String workId);

    /**
     * 根据id查找
     * @param studentWorkId
     * @return
     */
    StudentWork findByStudentWorkId(String studentWorkId);
}
