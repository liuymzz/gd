package com.lym.gd.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 作业附件📎
 *
 * @author liuyaming
 * @date 2018/3/11 下午6:17
 */
@Data
@Entity
public class WorkAttachment {

    @Id
    private String workAttachmentId;

    private String workId;

    /**
     * 附件文件名
     */
    private String workAttachmentName;

    /**
     * 附件链接🔗
     */
    @Column(length = 2000)
    private String workAttachmentUrl;

}
