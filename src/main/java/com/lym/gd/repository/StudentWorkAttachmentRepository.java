package com.lym.gd.repository;

import com.lym.gd.entity.StudentWorkAttachment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author liuyaming
 * @date 2018/4/27 下午3:26
 */
public interface StudentWorkAttachmentRepository extends JpaRepository<StudentWorkAttachment,String> {

    /**
     * 根据studentWorkId查找
     * @param studentWorkId
     * @return
     */
    List<StudentWorkAttachment> findByStudentWorkId(String studentWorkId);
}
