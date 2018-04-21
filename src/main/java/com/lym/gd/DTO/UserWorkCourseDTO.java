package com.lym.gd.DTO;

import com.lym.gd.entity.Course;
import com.lym.gd.entity.User;
import com.lym.gd.entity.Work;
import lombok.Data;

/**
 * @author liuyaming
 * @date 2018/4/21 下午7:03
 */
@Data
public class UserWorkCourseDTO {
    private User user;

    private Work work;

    private Course course;
}
