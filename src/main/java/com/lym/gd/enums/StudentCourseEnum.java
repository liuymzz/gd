package com.lym.gd.enums;

import lombok.Getter;

/**
 *
 * 学生选课表枚举类
 *
 * @author liuyaming
 * @date 2018/4/21 下午7:11
 */
@Getter
public enum StudentCourseEnum {

    NORMAL("1","正常状态"),
    NOT_NORMAL("2","非正常状态，课程已上完或者取消选课")
    ;

    private String code;

    private String message;

    StudentCourseEnum(String code,String message){
        this.code = code;
        this.message = message;
    }

}
