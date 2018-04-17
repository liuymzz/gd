package com.lym.gd.DTO;

import com.lym.gd.entity.Course;
import com.lym.gd.entity.CourseAttachment;
import com.lym.gd.entity.User;
import lombok.Data;

/**
 * @author liuyaming
 * @date 2018/4/17 下午2:10
 */
@Data
public class CourseDetailDTO {

    private User user;
    private Course course;
    private CourseAttachment courseAttachment;

}
