package com.lym.gd.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * 消息模板
 *
 * @author liuyaming
 * @date 2018/3/11 下午6:25
 */
@Data
@Entity
public class MessageTemplate {
    @Id
    private String messageTemplateId;

    private String messageTemplateContent;

    private String messageTemplateType;

    private Date messageTemplateCreateDate;

}
