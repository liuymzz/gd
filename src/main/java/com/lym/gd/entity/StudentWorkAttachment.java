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

    StudentWorkAttachment(){}
    private StudentWorkAttachment(Builder builder) {
        setStudentWorkAttachmentId(builder.studentWorkAttachmentId);
        setStudentWorkId(builder.studentWorkId);
        setStudentWorkAttachmentName(builder.studentWorkAttachmentName);
        setStudentWorkAttachmentUrl(builder.studentWorkAttachmentUrl);
    }

    public static final class Builder {
        private String studentWorkAttachmentId;
        private String studentWorkId;
        private String studentWorkAttachmentName;
        private String studentWorkAttachmentUrl;

        public Builder() {
        }

        public Builder studentWorkAttachmentId(String val) {
            studentWorkAttachmentId = val;
            return this;
        }

        public Builder studentWorkId(String val) {
            studentWorkId = val;
            return this;
        }

        public Builder studentWorkAttachmentName(String val) {
            studentWorkAttachmentName = val;
            return this;
        }

        public Builder studentWorkAttachmentUrl(String val) {
            studentWorkAttachmentUrl = val;
            return this;
        }

        public StudentWorkAttachment build() {
            return new StudentWorkAttachment(this);
        }
    }
}
