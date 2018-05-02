package com.lym.gd.service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lym.gd.DTO.CheckWorkDTO;
import com.lym.gd.DTO.UserWorkCourseDTO;
import com.lym.gd.DTO.WorkDetailDTO;
import com.lym.gd.entity.*;
import com.lym.gd.enums.WorkEnum;
import com.lym.gd.mapper.WorkMapper;
import com.lym.gd.repository.*;
import com.lym.gd.utils.IdUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
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
    private WorkMapper workMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentWorkRepository studentWorkRepository;

    @Autowired
    private StudentWorkAttachmentRepository studentWorkAttachmentRepository;

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

    public PageInfo<UserWorkCourseDTO> getUserWorkByUser(Integer page,Integer pageSize){
        PageHelper.startPage(page,pageSize);

        String userId = IdUtils.getUserId(httpSession);
        List<UserWorkCourseDTO> userWorkCourseDTOS = workMapper.getNormalWorkByStudent(userId);

        // 添加是否已经完成该作业标识
        userWorkCourseDTOS.forEach(userWorkCourseDTO -> {
            StudentWork studentWork
                    = studentWorkRepository.findByStudentWorkUserIdAndWorkId(IdUtils.getUserId(httpSession),userWorkCourseDTO.getWork().getWorkId());
            if (studentWork == null) {
                userWorkCourseDTO.setFinish(false);
            } else {
                userWorkCourseDTO.setFinish(true);
            }
        });


        return new PageInfo<>(userWorkCourseDTOS);
    }

    /**
     * 获取作业详细页面所需相关信息
     *
     * @param workId 作业id
     * @return
     */
    public WorkDetailDTO getWorkDetail(String workId) {
        WorkDetailDTO workDetailDTO = new WorkDetailDTO();

        Work work = workRepository.findWorkByWorkId(workId);

        List<WorkAttachment> workAttachments = workAttachmentRepository.findByWorkId(workId);

        Course course = courseRepository.findByCourseId(work.getCourseId());

        User user = userRepository.findByUserId(course.getCourseTeacherId());

        workDetailDTO.setUser(user);
        workDetailDTO.setWork(work);
        workDetailDTO.setWorkAttachments(workAttachments);

        StudentWork studentWork = studentWorkRepository.findByStudentWorkUserIdAndWorkId(IdUtils.getUserId(httpSession),workDetailDTO.getWork().getWorkId());

        if (studentWork == null) {
            workDetailDTO.setFinish(false);
        } else {
            workDetailDTO.setFinish(true);
        }

        return workDetailDTO;
    }

    /**
     * 获取所属课程状态为正在进行的作业
     * @param workId
     * @return
     */
    public Work getNormalWork(String workId){
        return workMapper.getNormalWorkByWorkId(workId);
    }

    /**
     * 提交作业
     * @param studentWork
     * @param studentWorkAttachment
     */
    @Transactional
    public void doWork(StudentWork studentWork,StudentWorkAttachment studentWorkAttachment){
        studentWorkRepository.save(studentWork);
        studentWorkAttachmentRepository.save(studentWorkAttachment);
    }

    /**
     * 批改作业列表界面，获取已提交作业的学生列表
     *
     * @param workId
     * @return
     */
    public PageInfo<CheckWorkDTO> getCheckWorkDTO(String workId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<CheckWorkDTO> checkWorkDTOS = workMapper.getUserAndStudentWorkByWorkId(workId);
        return new PageInfo<>(checkWorkDTOS);
    }

    /**
     * 根据courseId获取Work
     * @return
     */
    public List<Work> findWorksByCourseId(String courseId){
        return workRepository.findByCourseId(courseId);
    }
}
