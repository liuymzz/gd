package com.lym.gd.service;

import com.alibaba.fastjson.JSONObject;
import com.lym.gd.entity.Work;
import com.lym.gd.entity.WorkAttachment;
import com.lym.gd.enums.WorkEnum;
import com.lym.gd.repository.WorkAttachmentRepository;
import com.lym.gd.repository.WorkRepository;
import com.lym.gd.utils.IdUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

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
}
