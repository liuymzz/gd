package com.lym.gd.entity;

import lombok.Builder;
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
     * 1.正常。2取消(未选、过期)
     */
    private String courseStatus;

    StudentCourse(){}

    private StudentCourse(Builder builder) {
        setStudentCourseId(builder.studentCourseId);
        setCourseId(builder.courseId);
        setStudentId(builder.studentId);
        setCourseChooseDate(builder.courseChooseDate);
        setCourseStatus(builder.courseStatus);
    }


    public static final class Builder {
        private String studentCourseId;
        private String courseId;
        private String studentId;
        private Date courseChooseDate;
        private String courseStatus;

        public Builder() {
        }

        public Builder studentCourseId(String val) {
            studentCourseId = val;
            return this;
        }

        public Builder courseId(String val) {
            courseId = val;
            return this;
        }

        public Builder studentId(String val) {
            studentId = val;
            return this;
        }

        public Builder courseChooseDate(Date val) {
            courseChooseDate = val;
            return this;
        }

        public Builder courseStatus(String val) {
            courseStatus = val;
            return this;
        }

        public StudentCourse build() {
            return new StudentCourse(this);
        }
    }
}
