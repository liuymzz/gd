package com.lym.gd.service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lym.gd.DTO.UserWorkCourseDTO;
import com.lym.gd.entity.*;
import com.lym.gd.enums.CourseEnum;
import com.lym.gd.enums.StudentCourseEnum;
import com.lym.gd.enums.WorkEnum;
import com.lym.gd.mapper.WorkMapper;
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
    private WorkMapper workMapper;

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

        return new PageInfo<>(userWorkCourseDTOS);
    }

}
