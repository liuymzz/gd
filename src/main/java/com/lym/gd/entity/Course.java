package com.lym.gd.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * 课程
 *
 * @author liuyaming
 * @date 2018/3/11 下午5:49
 */
@Data
@Entity
public class Course {

    @Id
    private String courseId;

    /**
     * 课程老师的id
     */
    private String courseTeacherId;

    private String courseTitle;

    @Column(columnDefinition = "TEXT")
    private String courseContent;

    private Date courseCreateDate;

    private Date courseUpdateDate;

    /**
     * 课程开始时间
     */
    private Date courseStartDate;

    /**
     * 课程结束时间
     */
    private Date courseEndDate;

    /**
     * 1.未开始。2.进行中。3.已结束
     */
    private String courseStatus = "1";


}
