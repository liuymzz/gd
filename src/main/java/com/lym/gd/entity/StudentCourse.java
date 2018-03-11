package com.lym.gd.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * 学生已选课程表
 *
 * @author liuyaming
 * @date 2018/3/11 下午6:10
 */
@Entity
@Data
public class StudentCourse {

    @Id
    private String studentCourseId;

    private String courseId;

    private String studentId;

    /**
     * 选课时间
     */
    private Date courseChooseDate;

    /**
     * 选课状态
     * 1.正常。2取消
     */
    private String courseStatus;

}
