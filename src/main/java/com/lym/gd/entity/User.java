package com.lym.gd.entity;

import com.lym.gd.utils.IdUtils;
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

    private String userPassword;

    public User(){}

    /**
     * 用户头像地址
     */
    @Column(length = 500)
    private String userIcon = "http://www.qqzhi.com/uploadpic/2014-09-06/195035496.jpg";

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

    private User(Builder builder) {
        setUserId(IdUtils.getUserId());
        setUserName(builder.userName);
        setUserPhone(builder.userPhone);
        setUserIcon(builder.userIcon);
        setUserSex(builder.userSex);
        setUserCreateDate(builder.userCreateDate);
        setUserUpdateDate(builder.userUpdateDate);
        setUserRole(builder.userRole);
        setUserGrade(builder.userGrade);
        setMajor(builder.major);
        setUserSignature(builder.userSignature);
    }

    public static final class Builder {
        private String userName;
        private String userPhone;
        private String userIcon;
        private String userSex;
        private Date userCreateDate;
        private Date userUpdateDate;
        private String userRole;
        private String userGrade;
        private String major;
        private String userSignature;

        public Builder() {
        }


        public Builder userName(String val) {
            userName = val;
            return this;
        }

        public Builder userPhone(String val) {
            userPhone = val;
            return this;
        }

        public Builder userIcon(String val) {
            userIcon = val;
            return this;
        }

        public Builder userSex(String val) {
            userSex = val;
            return this;
        }

        public Builder userCreateDate(Date val) {
            userCreateDate = val;
            return this;
        }

        public Builder userUpdateDate(Date val) {
            userUpdateDate = val;
            return this;
        }

        public Builder userRole(String val) {
            userRole = val;
            return this;
        }

        public Builder userGrade(String val) {
            userGrade = val;
            return this;
        }

        public Builder major(String val) {
            major = val;
            return this;
        }

        public Builder userSignature(String val) {
            userSignature = val;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
