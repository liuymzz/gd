package com.lym.gd.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 学生提交的作业的附件信息表
 *
 * @author liuyaming
 * @date 2018/4/21 下午6:50
 */
@Entity
@Data
public class StudentWorkAttachment {

    @Id
    private String studentWorkAttachmentId;

    private String studentWorkId;

    /**
     * 附件名
     */
    private String studentWorkAttachmentName;

    /**
     * 附件链接
     */
    private String studentWorkAttachmentUrl;

}
