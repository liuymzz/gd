package com.lym.gd.schedule;

import com.lym.gd.mapper.CourseMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 *
 * 课程相关定时任务
 *
 * @author liuyaming
 * @date 2018/5/3 上午9:54
 */
@Component
@Slf4j
public class CourseSchedule {

    @Autowired
    private CourseMapper courseMapper;

    /**
     * 课程状态更新,在每天23点进行更新
     */
    @Scheduled(cron = "0 0 23 * * *")
    public void courseStatusUpdate(){
        int starting = courseMapper.updateCourseStatus2Starting();

        int end = courseMapper.updateCourseStatus2End();

        log.info("{}门课程开始上课",starting);
        log.info("{}门课程已经结束",end);
    }

}
