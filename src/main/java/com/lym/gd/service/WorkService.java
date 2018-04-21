package com.lym.gd.service;

import com.alibaba.fastjson.JSONObject;
import com.lym.gd.DTO.UserWorkCourseDTO;
import com.lym.gd.entity.*;
import com.lym.gd.enums.CourseEnum;
import com.lym.gd.enums.StudentCourseEnum;
import com.lym.gd.enums.WorkEnum;
import com.lym.gd.repository.*;
import com.lym.gd.utils.IdUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author liuyaming
 * @date 2018/4/18 下午5:28
 */
@Service
public class WorkService {
    @Autowired
    private WorkRepository workRepository;

    @Autowired
    private WorkAttachmentRepository workAttachmentRepository;

    @Autowired
    private HttpSession httpSession;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentCourseRepository studentCourseRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void publishWork(JSONObject jsonObject) {
        Work work = new Work();
        WorkAttachment workAttachment = null;

        work.setWorkId(IdUtils.getWorkId());
        work.setCourseId(jsonObject.getString("courseId"));
        work.setWorkContent(jsonObject.getString("workContent"));
        work.setWorkTitle(jsonObject.getString("workTitle"));
        work.setWorkCreateDate(new Date());
        work.setWorkStatus(WorkEnum.NORMAL.getCode());

//        如果这个属性不为空则表示有上传文件
        if (StringUtils.isNotEmpty(jsonObject.getString("workAttachmentUrl"))){
            String workAttachmentUrl = jsonObject.getString("workAttachmentUrl");
//            在URL中使用了“###”分隔原始文件名跟随机id，存放到数据库之前先进行转换，这样URL就可以直接在浏览器中进行访问了
            String workAttachmentName = workAttachmentUrl.substring(workAttachmentUrl.indexOf("###") + 3);
            workAttachmentUrl = workAttachmentUrl.replace("#","%23");

            workAttachment = new WorkAttachment();
            workAttachment.setWorkAttachmentId(IdUtils.getWorkAttachmentId());
            workAttachment.setWorkId(work.getWorkId());
            workAttachment.setWorkAttachmentName(workAttachmentName);
            workAttachment.setWorkAttachmentUrl(workAttachmentUrl);
            workAttachmentRepository.save(workAttachment);
        }

        workRepository.save(work);
    }

    public List<UserWorkCourseDTO> getWorkByUser() {
        // 这里的user指的是布置这个作业的老师
        List<UserWorkCourseDTO> userWorkCourseDTOS = new ArrayList<>();

        // 通过学生选课表获取学生已选的课程
        String studentId = IdUtils.getUserId(httpSession);

        List<StudentCourse> studentCourses = studentCourseRepository.findByStudentIdAndCourseStatus(studentId, StudentCourseEnum.NORMAL.getCode());

        // 再根据学生已选课数据查询对应课程信息
        List<Course> courses = new ArrayList<>();
        studentCourses.forEach(studentCourse -> courses.add(courseRepository.findByCourseId(studentCourse.getCourseId())));

        // 最后利用查询出来的符合条件的课程信息封装至UserWorkCourseDTOs对象中，并且把user跟work对象也补全
        courses.forEach(course -> {
            // 查询出该课程老师
            User user = userRepository.findByUserId(course.getCourseTeacherId());

            // 同一门课程可能会有多次作业
            List<Work> works = workRepository.findByCourseIdAndWorkStatus(course.getCourseId(),WorkEnum.NORMAL.getCode());
            works.forEach(work -> {
                UserWorkCourseDTO userWorkCourseDTO = new UserWorkCourseDTO();
                userWorkCourseDTO.setCourse(course);
                userWorkCourseDTO.setUser(user);
                userWorkCourseDTO.setWork(work);

                userWorkCourseDTOS.add(userWorkCourseDTO);
            });
        });


        return userWorkCourseDTOS;
    }

}
