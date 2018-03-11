package com.lym.gd.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * 用户
 *
 * @author liuyaming
 * @date 2018/3/11 下午5:22
 */
@Data
@Entity
public class User {

    @Id
    private String userId;

    private String userName;

    private String userPhone;

    /**
     * 用户头像地址
     */
    @Column(length = 500)
    private String userIcon;

    /**
     * 0.女生。1.男生
     */
    private String userSex;

    private Date userCreateDate;

    private Date userUpdateDate;

    /**
     * 用户角色
     * 1:学生。2:老师。3:管理员
     */
    private String userRole;

    /**
     * 如果是学生则为年级
     * 其他角色为空
     */
    private String userGrade;

    /**
     * 如果是学生则为专业
     * 其他角色为空
     */
    private String major;

    /**
     * 个性签名
     */
    @Column(length = 500)
    private String userSignature;
}
