package com.lym.gd.DTO;

import com.lym.gd.entity.Course;
import com.lym.gd.entity.User;
import lombok.Data;

/**
 * @author liuyaming
 * @date 2018/4/16 下午2:12
 */
@Data
public class CourseAndUserDTO {
    private Course course;
    private User user;
}
