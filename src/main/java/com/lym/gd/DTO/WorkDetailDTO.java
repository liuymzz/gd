package com.lym.gd.DTO;

import com.lym.gd.entity.User;
import com.lym.gd.entity.Work;
import com.lym.gd.entity.WorkAttachment;
import lombok.Data;

import java.util.List;

/**
 * @author liuyaming
 * @date 2018/4/26 下午1:25
 */
@Data
public class WorkDetailDTO {
    private User user;
    private Work work;
    private List<WorkAttachment> workAttachments;

    /**
     * 是否已完成该作业
     */
    private boolean finish;

}
