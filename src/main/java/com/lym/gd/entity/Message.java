package com.lym.gd.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author liuyaming
 * @date 2018/3/11 下午6:22
 */
@Data
@Entity
public class Message {

    @Id
    private String messageId;

    /**
     * 此信息发给指定UserId的用户
     */
    private String messageUserId;

    private Date messageCreateDate;

    private String messageContent;

    /**
     * 消息状态
     * 1.未读。2.已读。3.删除
     */
    private String messageStatus;

}
