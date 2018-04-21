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

    private String studentWorkUserId;

    private String studentWorkCourseId;

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

}
