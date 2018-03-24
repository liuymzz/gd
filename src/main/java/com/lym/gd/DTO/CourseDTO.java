package com.lym.gd.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class CourseDTO {
    private String courseId;

    /**
     * 课程老师的id
     */
    private String courseTeacherId;

    private String courseName;

    private String courseTitle;

    private String courseDescription;

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
     * 课程时间安排
     */
    private String courseSchoolTime;

    /**
     * 1.未开始。2.进行中。3.已结束
     */
    private String courseStatus;

    /**
     * 课程附件ID
     */
    private String courseAttachmentId;


}
