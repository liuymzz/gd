package com.lym.gd.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 *
 * 学生作业表，存储学生已完成的作业内容
 *
 * @author liuyaming
 * @date 2018/4/21 下午6:45
 */
@Data
@Entity
public class StudentWork {

    @Id
    private String studentWorkId;

    /**
     * 学生ID
     */
    private String studentWorkUserId;

    private String workId;

    /**
     * 作业内容
     */
    @Column(columnDefinition = "TEXT")
    private String studentWorkContent;

    /**
     * 作业状态：1。未阅   2.已阅
     */
    private String studentWorkStatus;

    /**
     * 提交时间
     */
    private Date studentWorkSubmitDate;

    StudentWork(){}

    private StudentWork(Builder builder) {
        setStudentWorkId(builder.studentWorkId);
        setStudentWorkUserId(builder.studentWorkUserId);
        setWorkId(builder.workId);
        setStudentWorkContent(builder.studentWorkContent);
        setStudentWorkStatus(builder.studentWorkStatus);
        setStudentWorkSubmitDate(builder.studentWorkSubmitDate);
    }


    public static final class Builder {
        private String studentWorkId;
        private String studentWorkUserId;
        private String workId;
        private String studentWorkContent;
        private String studentWorkStatus;
        private Date studentWorkSubmitDate;

        public Builder() {
        }

        public Builder studentWorkId(String val) {
            studentWorkId = val;
            return this;
        }

        public Builder studentWorkUserId(String val) {
            studentWorkUserId = val;
            return this;
        }

        public Builder workId(String val) {
            workId = val;
            return this;
        }

        public Builder studentWorkContent(String val) {
            studentWorkContent = val;
            return this;
        }

        public Builder studentWorkStatus(String val) {
            studentWorkStatus = val;
            return this;
        }

        public Builder studentWorkSubmitDate(Date val) {
            studentWorkSubmitDate = val;
            return this;
        }

        public StudentWork build() {
            return new StudentWork(this);
        }
    }
}
