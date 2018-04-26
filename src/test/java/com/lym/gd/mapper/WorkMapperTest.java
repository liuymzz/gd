package com.lym.gd.mapper;

import com.lym.gd.DTO.UserWorkCourseDTO;
import com.lym.gd.repository.WorkRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author liuyaming
 * @date 2018/4/22 下午2:47
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.lym.gd.mapper")
public class WorkMapperTest {

    @Autowired
    private WorkMapper workMapper;

    @Test
    public void getAll() {

        List<UserWorkCourseDTO> userWorkCourseDTOS = workMapper.getNormalWorkByStudent("456");

        userWorkCourseDTOS.forEach(System.out::println);

        System.out.println(workMapper.getNormalWorkByStudent("456"));

    }
}