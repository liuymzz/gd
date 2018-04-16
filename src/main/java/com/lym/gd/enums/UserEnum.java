package com.lym.gd.enums;

import lombok.Getter;

/**
 * @author liuyaming
 * @date 2018/4/16 下午2:34
 */
@Getter
public enum UserEnum {
    STUDENT("1","学生"),
    TEACHER("2","老师"),
    ADMINISTRATOR("3","管理员"),
    FEMALE("0","女生"),
    MALE("1","男生")
    ;
    private String code;
    private String message;

    UserEnum(String code,String message){
        this.code = code;
        this.message = message;
    }
}
