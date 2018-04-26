package com.lym.gd.repository;

import com.lym.gd.entity.WorkAttachment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author liuyaming
 * @date 2018/3/11 下午6:21
 */
public interface WorkAttachmentRepository extends JpaRepository<WorkAttachment,String> {

    /**
     * 根据id获取
     * @param workAttachmentId
     * @return
     */
    WorkAttachment findByWorkAttachmentId(String workAttachmentId);

    /**
     * 根据WorkId获取
     * @param workId
     * @return
     */
    List<WorkAttachment> findByWorkId(String workId);

}
