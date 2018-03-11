package com.lym.gd.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 课程附件
 *
 * @author liuyaming
 * @date 2018/3/11 下午6:04
 */
@Data
@Entity
public class CourseAttachment {
    @Id
    private String courseAttachmentId;

    private String courseId;

    /**
     * 附件文件名📎
     */
    private String courseAttachmentName;

    /**
     * 附件链接🔗
     */
    @Column(length = 2000)
    private String courseAttachmentUrl;
}
