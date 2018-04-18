package com.lym.gd.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * 老师布置的作业
 *
 * @author liuyaming
 * @date 2018/3/11 下午6:12
 */
@Data
@Entity
public class Work {

    @Id
    private String workId;

    private String workTitle;

    /**
     * 作业对应课程的id🆔
     */
    private String courseId;

    /**
     * 作业内容
     */
    @Column(columnDefinition = "TEXT")
    private String workContent;

    /**
     * 作业状态
     * 1.未阅。2.已阅
     */
    private String workStatus;

    private Date workCreateDate;
}
