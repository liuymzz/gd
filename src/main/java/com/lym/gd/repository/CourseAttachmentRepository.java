package com.lym.gd.repository;


import com.lym.gd.entity.CourseAttachment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author liuyaming
 * @date 2018/3/11 下午6:07
 */
public interface CourseAttachmentRepository extends JpaRepository<CourseAttachment,String> {

    /**
     * 根据courseId查找他对应的附件信息
     * @param courseId
     * @return
     */
    CourseAttachment findByCourseId(String courseId);

}
