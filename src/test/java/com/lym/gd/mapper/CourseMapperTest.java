package com.lym.gd.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author liuyaming
 * @date 2018/4/26 下午2:55
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.lym.gd.mapper")
public class CourseMapperTest {
    @Autowired
    private  CourseMapper courseMapper;

    @Test
    public void findCourseAndUserByCourseStatus() {
        System.out.println(courseMapper.findCourseAndUserByCourseStatus("1"));
    }

    @Test
    public void updateCourseStatus2StartingTest(){
        System.out.println(courseMapper.updateCourseStatus2Starting());
    }
}